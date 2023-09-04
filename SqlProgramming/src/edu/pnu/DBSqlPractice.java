package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class DBSqlPractice {
	public static void main(String[] args) {

		Connection con = null;
		try {

			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			Scanner sc = new Scanner(System.in);
			System.out.print("쿼리문을 입력하세요: ");
			String inputQuery = sc.next();
			showQuery(con, inputQuery);
//			String s = null;
//			showQuery(con, s);
			con.close();

		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}

	}

	private static void showQuery(Connection con, String inputQuery) throws Exception {
		// TODO Auto-generated method stub
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(inputQuery);
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		for (int j = 1; j <= count; j++) {
			System.out.print(String.format("%30s", rsmd.getColumnName(j)));
		}
		System.out.println("\n" + "=".repeat(100));
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(String.format("%30s", rs.getString(i)));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
}
