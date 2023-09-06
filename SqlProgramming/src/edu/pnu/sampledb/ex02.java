package edu.pnu.sampledb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

public class ex02 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String user = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			executeProcedure2(con);
			
			con.close();
			
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}

	private static void executeProcedure2(Connection con) {
		try {
			String sql = "CALL myStoredProc2(?, ?)";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, "user3%");
			cs.registerOutParameter(2, Types.INTEGER);
			
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			if (rsmd.getColumnCount() > 0) {// 커서 프로세싱을 위해 컬럼 카운트가 0보다 클 경우에만 출력
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 2; i <= rsmd.getColumnCount(); i++) {
						System.out.print(", " + rs.getString(i));
					}
					System.out.println();
				}
			}
			
			System.out.println("-".repeat(10));
			System.out.println(cs.getInt(2));
			rs.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
