package edu.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ex07 {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sqltest";
			String user = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql;
			Statement st = con.createStatement();
//			for (int i = 0; i < 100; i++) {
//				sql = "insert into user (username, password, role, enable, joindate) values ('user" + i + "', 'password" + i + "', 'user', true, now())";
//				System.out.println("user" + i + ":" + st.executeUpdate(sql));
//			}
			int k = 0;
			while (k < 100) {
				sql = "insert into user (username, password, role, enable, joindate) values ('user" + k + "', 'password" + k + "', 'user', true, now())";
				System.out.println("user" + k + ":" + st.executeUpdate(sql));
				k++;
			}
//			sql = "UPDATE user SET enable = false WHERE username like 'user2%'";
//			System.out.println("수정된 건수: " + st.executeUpdate(sql));
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
