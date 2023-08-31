package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class ex05 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/world";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("쿼리문을 입력하세요 : ");
			String inputQuery = sc.nextLine();
			
			// 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요.
//			"select * from city where countrycode = 'KOR' and population >= 1000000 limit 100;"
			// 국가코드가 'KOR'인 도시 중 인구수가 많은 순서로 상위 10개만 표시하세요.
//			"select * from city where countrycode = 'KOR' order by population desc limit 10;"
			// city 테이블에서 국가코드가 'KOR'이고, 인구가 100만 이상 500만 이하인 도시를 찾으세요.
//			"select * from city where countrycode = 'KOR' and population >= 1000000 and population <= 5000000 order by population desc;"
			// city 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요.
//			"select count(name) qty, countrycode from city where countrycode = 'KOR';"
			// city 테이블에서 국가별 도시의 수를 표시하세요.
//			"select count(name) qty, countrycode from city group by countrycode;"
			// city 테이블에서 국가별 도시의 수를 표시하고, 국가명도 같이 표시하세요.
//			"select count(c.name) qty, ct.code from city c join country ct on c.countrycode = ct.code group by ct.code;"
			// 도시의 수가 10개 이상인 국가에 대해서, city 테이블에서 국가별 도시의 수를 표시하고, 국가명도 같이 표시하세요.
//			"select c1.countrycode, count(c1.name) as city_count from city c1 join (select countrycode, count(name) as city_count from city group by countrycode) c2 on c1.countrycode = c2.countrycode where c2.city_count >= 10 group by c1.countrycode, city_count;"
			
			showData(con, inputQuery);
			con.close();
			
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
		}
	}

	private static void showData(Connection con, String myquery) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(myquery);
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		System.out.println("=".repeat(100));
		for (int i = 1; i <= count; i++) {
			System.out.print(String.format("%-30s", rsmd.getColumnName(i)));
		}
		System.out.println("\n" + "=".repeat(100));
		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(String.format("%-30s", rs.getString(i)));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}

}
