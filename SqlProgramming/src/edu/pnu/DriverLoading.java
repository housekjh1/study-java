package edu.pnu;

public class DriverLoading {

	public static void main(String[] args) {

		try {
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			System.out.println("로딩 성공");

		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
		}
	}
}
