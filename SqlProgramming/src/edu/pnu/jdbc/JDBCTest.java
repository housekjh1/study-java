package edu.pnu.jdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {

		MyJDBC mj = new MyJDBC("com.mysql.cj.jdbc.Driver",
								"jdbc:mysql://localhost:3306/world",
								"scott",
								"tiger");

		Scanner sc = new Scanner(System.in);
		System.out.print("쿼리문을 입력해주세요.: ");
		String a = sc.nextLine();
		System.out.print("쿼리문을 입력해주세요.: ");
		String b = sc.nextLine();

		try {
//			List<List<String>> list = mj.queryWithStatement(a);
			List<List<String>> list = mj.queryWithPreparedStatement("select * from country where population > ? and gnp > ? order by gnp desc", a, b);
			mj.printList(list);
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
