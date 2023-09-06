package edu.pnu.sampledb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ex01 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/sampledb";
			String user = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			executeProcedure(con);
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}

	private static void executeProcedure(Connection con) {
		try {
			CallableStatement cs = con.prepareCall("CALL MyFirst(?)");
			cs.setString(1, "Toy Land");
			ResultSet rs = cs.executeQuery();
			
			while (rs.next()) {
				System.out.print(String.format("%-20s", rs.getString("cust_name")));
				System.out.print(String.format("%-20s", rs.getString("cust_contact")));
				System.out.print(String.format("%-20s", rs.getString("cust_email")));
				System.out.println();
			}
			rs.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
