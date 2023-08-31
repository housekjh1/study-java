package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select countrycode, name from city where countrycode in ('KOR', 'CHN', 'JPN') order by countrycode asc;");
			
			while(rs.next()) {
				System.out.print(String.format("%10s", rs.getString("countrycode")));
				System.out.print(String.format("%20s", rs.getString("name")) + "\n");
			}
			rs.close();
			st.close();
			con.close();
			
		}catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
