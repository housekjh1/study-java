package edu.pnu.sampledb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.Scanner;

public class ex04 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			getPercentage(con);

			con.close();

		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}

	private static void getPercentage(Connection con) {
		try {
			String sql = "CALL nationLanguage02(?, ?)";
			Scanner sc = new Scanner(System.in);
			System.out.print("국가명을 입력하세요: ");
			String s = sc.nextLine();

			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, s);
			cs.registerOutParameter(2, Types.FLOAT);
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();

			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(String.format("%-30s", rs.getString("language")));
					System.out.print(String.format("%-30s", rs.getString("isofficial")));
					System.out.print(String.format("%-30s", rs.getString("percentage")));
					System.out.println();
				}
			}
			System.out.println("=".repeat(80));
			System.out.println(cs.getFloat(2));
			rs.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
