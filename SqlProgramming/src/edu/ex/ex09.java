package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ex09 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			Scanner sc = new Scanner(System.in);
			System.out.print("enable 값을 입력하세요: ");
			boolean enableValue = sc.nextBoolean();
			System.out.print("user?% 값을 입력하세요: ");
			int userValue = sc.nextInt();
			PreparedStatement pst = con.prepareStatement("update user set enable = ? where username like ?");
			pst.setBoolean(1, enableValue);
			pst.setString(2, "user" + userValue + "%");
			System.out.println("업데이트 건수: " + pst.executeUpdate());
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
