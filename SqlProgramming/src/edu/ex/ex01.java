package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;

class Data {
	private int id;
	private String name;
	private String countrycode;
	private String district;
	private int population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", countrycode=" + countrycode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
}

public class ex01 {
/*	public static void main(String[] args) {

		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from city limit 10;");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			ArrayList<Data> list = new ArrayList<>();
			while (rs.next()) {
//				System.out.print(String.format("%10d", rs.getInt("id")));
//				System.out.print(String.format("%20s", rs.getString("name")));
//				System.out.print(String.format("%10s", rs.getString("countrycode")));
//				System.out.print(String.format("%20s", rs.getString("district")));
//				System.out.print(String.format("%10d", rs.getInt("population")) + "\n");
				for (int i = 0; i < count; i++) {
					Data d = new Data();
					d.setId(rs.getInt("id"));
					list.add(d);
					d.setName(rs.getString("name"));
					list.add(d);
					d.setCountrycode(rs.getString("countrycode"));
					list.add(d);
					d.setDistrict(rs.getString("district"));
					list.add(d);
					d.setPopulation(rs.getInt("population"));
					list.add(d);
				}
			}
			
			for (Data d : list) {
				System.out.println(d.get);
			}
//			showData(con, "city", "*");
//			showData(con, "country", "*");
//			showData(con, "countrylanguage", "*");
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

//	private static void showData(Connection con, String tablename, String fields) throws Exception {
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(String.format("select %s from %s limit 10", fields, tablename));
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int count = rsmd.getColumnCount();
//
//		System.out.println("=".repeat(80));
//		System.out.println("Table : " + tablename);
//		System.out.println("=".repeat(80));
//		while (rs.next()) {
//			for (int i = 1; i <= count; i++) {
//				if (i != 1)	System.out.print(",");
//				System.out.print(rs.getString(i));
////				System.out.print(String.format("%s", rsmd.getColumnName(i)));
//			}
//			System.out.println();
//		}
//		rs.close();
//		st.close();
//	}
 */
	
	public static void main(String[] args) throws Exception {
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "scott";
		String password = "tiger";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		
		List<Data> list = getDataList(con, "select * from city limit 10;");
		printData(list);
		
		con.close();
	}

	private static void printData(List<Data> list) {
		for (Data d : list) {
            System.out.println(d);
        }
			
	}

	private static List<Data> getDataList(Connection con, String string) {
		List<Data> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(string);

            while (rs.next()) {
                Data d = new Data();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setCountrycode(rs.getString("countrycode"));
                d.setDistrict(rs.getString("district"));
                d.setPopulation(rs.getInt("population"));
                list.add(d);
            }
            
            rs.close();
            st.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
		return list;
	}
}
