package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ex01 {
	public static void main(String[] args) {

		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from city,country,countrylanguage where city.countrycode = country.code and country.code = countrylanguage.countrycode limit 10");

//			while (rs.next()) {
//				System.out.print(String.format("%10d", rs.getInt("id")));
//				System.out.print(String.format("%20s", rs.getString("name")));
//				System.out.print(String.format("%10s", rs.getString("countrycode")));
//				System.out.print(String.format("%20s", rs.getString("district")));
//				System.out.print(String.format("%10d", rs.getInt("population")) + "\n");
//			}
//			rs.close();
//			st.close();
			showData(con, "city", "*");
			showData(con, "country", "*");
			showData(con, "countrylanguage", "*");
			con.close();

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

	private static void showData(Connection con, String tablename, String fields) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(String.format("select %s from %s limit 10", fields, tablename));
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();

		System.out.println("=".repeat(80));
		System.out.println("Table : " + tablename);
		System.out.println("=".repeat(80));
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				if (i != 1)	System.out.print(",");
				System.out.print(rs.getString(i));
//				System.out.print(String.format("%s", rsmd.getColumnName(i)));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
}
