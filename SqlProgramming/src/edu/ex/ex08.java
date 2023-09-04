package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex08 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String user = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "update user set enable = false where username like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "user3%");
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
