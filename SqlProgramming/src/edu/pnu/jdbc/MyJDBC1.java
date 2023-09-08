//package edu.pnu.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyJDBC1 {
//
//	private String driver;
//	private String url;
//	private String user;
//	private String password;
//	
//	public MyJDBC1(String driver, String url, String user, String password) {
//
//		this.driver = driver;
//		this.url = url;
//		this.user = user;
//		this.password = password;
//		
//		try {
//			Class.forName(this.driver);
//		} catch (Exception e) {
//			System.out.println("연결 실패: " + e.getMessage());
//		}
//	}
//
//	private Connection getConnection() {
//
//		try {
//			return DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			System.out.println("연결 실패: " + e.getMessage());
//		}
//		return null;
//	}
//
//	public List<List<String>> queryWithStatement(String query) {
//		
//		try {
//			Connection con = getConnection();
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
//			List<List<String>> result = new ArrayList<List<String>>();
//			int count = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				List<String> list = new ArrayList<String>();
//				for (int i = 1; i <= count; i++) {
//					list.add(rs.getString(i));
//				}
//				result.add(list);
//			}
//			rs.close();
//			st.close();
//			con.close();
//			return result;
//		} catch (SQLException e) {
//			System.out.println("연결 실패: " + e.getMessage());
//		}
//		return null;
//	}
//
//	public List<List<String>> queryWithPreparedStatement(String query, String... args) {
//		
//		try {
//			Connection con = getConnection();
//			PreparedStatement pst = getConnection().prepareCall(query);
//			for (int i = 1; i <= args.length; i++) {
//				for (String s : args) {
//					pst.setString(i, s);
//				}
//			}
//			ResultSet rs = pst.executeQuery();
//			List<List<String>> result = new ArrayList<List<String>>();
//			int count = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				List<String> list = new ArrayList<String>();
//				for (int i = 1; i <= count; i++) {
//					list.add(rs.getString(i));
//				}
//				result.add(list);
//			}
//			rs.close();
//			pst.close();
//			con.close();
//			return result;
//		} catch (SQLException e) {
//			System.out.println("연결 실패: " + e.getMessage());
//		}
////		for (String a : args) {
////			System.out.print(a + " ");
////		}
//		return null;
//	}
//
//	
//	public void printList(List<List<String>> result) {
//
//		for (List<String> list : result) {
//			for (String s : list) {
//				System.out.print(s + " ");
//			}
//			System.out.println();
//		}
//	}
//}
