package edu.pnu.sakila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyQuery {

	public static void main(String[] args) throws Exception {

		StudyQuery sq = new StudyQuery();// 객체 생성

		Connection con = sq.getConnection();// 데이터베이스 연결 (con)

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("테이블 이름: ");
			String tableName = sc.next();// 테이블 이름 입력

			if (tableName.equals("0"))// 종료 조건
				break;

//			List<List<String>> list = sq.getQueryResult(con, tableName);// 테이블 네임을 넘긴 후 질의 결과를 리스트형으로 리턴받아옴
			sq.getQueryResult(con, tableName);
//			sq.printResult(list);
		}
		con.close();
	}

//	private void printResult(List<List<String>> list) {
//		for (List<String> row : list) {// 2차원 배열인 list를 1차원 배열 row로 받아 출력
//			System.out.println(row);
//		}
//	}

	private void getQueryResult(Connection con, String tableName) throws SQLException {
		List<List<String>> result = new ArrayList<>();// 2차원 리스트 생성
		Statement st = con.createStatement();// 스테이트먼트 생성
		ResultSet rs = st.executeQuery("select * from " + tableName + " limit 1000;");// 질의문 리턴타입인 ResultSet으로 rs에 반환
		int count = rs.getMetaData().getColumnCount();//
		while (rs.next()) {
			List<String> list = new ArrayList<String>();
			for (int i = 1; i <= count; i++) {
				list.add(rs.getString(i));
			}
			result.add(list);
		}
		for (int j = 1; j <= count; j++) {
			int a = rs.getMetaData().getColumnDisplaySize(j);
			int b = rs.getMetaData().getColumnName(j).length();
			System.out.print(String.format("%" + (a > b ? a : b) + "s", rs.getMetaData().getColumnName(j)));
		}
		System.out.println();
		for (List<String> row : result) {
			for (int k = 0; k < count; k++) {
				if (rs.getMetaData().getColumnDisplaySize(k + 1) < row.get(k).length())
					System.out.print(String.format("%" + row.get(k).length() + "s", row.get(k)));
				else
					System.out.print(String.format("%" + rs.getMetaData().getColumnDisplaySize(k + 1) + "s", row.get(k)));
			}
			System.out.println();
		}
		rs.close();
		st.close();
//		return result;
	}

	private Connection getConnection() throws Exception {

		String url = "jdbc:mysql://localhost:3306/sakila";
		String user = "scott";
		String password = "tiger";

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, user, password);
	}
}
