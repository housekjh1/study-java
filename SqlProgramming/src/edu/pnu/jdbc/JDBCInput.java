package edu.pnu.jdbc;

public class JDBCInput {
	public static void main(String[] args) {
		
		MyJDBC mj = new MyJDBC("org.h2.Driver",
								"jdbc:h2:tcp://localhost/~/.h2/jdbcstudy",
								"sa",
								"abcd");
		
		String sql;
		
		int k = 0;
		while (k < 100) {
			sql = "insert into testtable (name, telephone, address) values ('user" + k + "', '" + k + "', 'address" + k + "')";
			mj.executeStatementUpdate(sql);
			System.out.println("user" + k);
			k++;
		}
	}
}
