package edu.pnu.sampledb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class ex03 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			myLang01(con);

			con.close();

		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}

	private static void myLang01(Connection con) {
		try {
			String sql = "CALL nationLanguage01(?);";
			Scanner sc = new Scanner(System.in);
			System.out.print("국가명을 입력하세요: ");
			String my = sc.nextLine();// 나라 이름에 공백이 있을 시 next()는 온전히 입력받지 못함

			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, my);
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData md = rs.getMetaData();

			if (md.getColumnCount() > 0) {
				while (rs.next()) {
					System.out.print(String.format("%-20s", rs.getString("language")));
					System.out.print(String.format("%-20s", rs.getString("isofficial")));
					System.out.print(String.format("%-20s", rs.getString("percentage")));
					System.out.println();
				}
			}

			rs.close();
			cs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
