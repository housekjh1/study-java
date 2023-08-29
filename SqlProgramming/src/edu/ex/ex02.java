package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ex02 {
	public static void main(String[] args) {
		// Driver, Connection, Statement -> Prepared Statement
		Connection con = null;
		try {
		String driver = "com.mysql.cj.jdbc.Driver";// 드라이버 로드
		String url = "jdbc:mysql://localhost:3306/world";// 데이터베이스 연결
		String username = "scott";
		String password = "tiger";
		
		Class.forName(driver);// MySQL 드라이버 클래스 로드
		con = DriverManager.getConnection(url, username, password);// 데이터베이스 연결 생성
		
		Statement st = con.createStatement();// SQL 문 실행을 위한 Statement 객체 생성, 질의를 하기위한 목적
		ResultSet rs = st.executeQuery("select country.code,city.name,city.population from city,country where city.countrycode = country.code and country.code = 'KOR' order by city.population desc");// SQL 쿼리 실행
		
		while (rs.next()) {// 가상 출발지는 빈 행, 다음 행(첫 번째 행)으로 커서를 가리키고 끝 행 이후 null이 나오고 false 출력
			System.out.print(String.format("%10s", rs.getString("country.code")));
			System.out.print(String.format("%20s", rs.getString("city.name")));
			System.out.print(String.format("%20d", rs.getInt("city.population")) + "\n");
		}
		rs.close();
		st.close();
		con.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}
}
