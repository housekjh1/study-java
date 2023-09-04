package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ex06 {
	public static void main(String[] args) {

		Connection con = null;
		try {

			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			PreparedStatement pst = con.prepareStatement("select id,name,countrycode,district,population from city where countrycode = ? and population >= 1000000 order by population desc;");
			pst.setString(1, "KOR");
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			for(int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnName(i) + ", ");
			}
			System.out.println();
			while (rs.next()) {
				System.out.print(rs.getInt("id") + ", ");
				System.out.print(rs.getString("name") + ", ");
				System.out.print(rs.getString("countrycode") + ", ");
				System.out.print(rs.getString("district") + ", ");
				System.out.print(rs.getInt("population") + "\n");
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
