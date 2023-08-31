package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

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
		
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select countrycode,population from city order by countrycode asc, population desc;");
		
//		while (rs.next()) {
//			System.out.print(String.format("%10s", rs.getString("countrycode")));
//			System.out.print(String.format("%20d", rs.getInt("population")));
//			System.out.println();
//		}
//		rs.close();
//		st.close();
		
		showData(con, "city", "*");
		con.close();
		
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
	
	private static void showData(Connection con, String tablename, String field) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(String.format("select %s from %s limit 100;", field, tablename));
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		
		System.out.println("=".repeat(80));
		System.out.println("Table : " + tablename);
		System.out.println("=".repeat(80));
//		for (int i = 1; i <= count; i++) {
//			System.out.print(String.format("%s", rsmd.getColumnName(i)) + ",");
//		}
		System.out.println();
		while(rs.next()) {
			for (int i = 1; i <= count; i++) {
				if (i != 1) System.out.print(",");
				System.out.print(rs.getString(i));
//				System.out.print(String.format("%s", rsmd.getColumnName(i)));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
}
