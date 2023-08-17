package test;

public class Temp2 {
	private static int test1() throws Exception {
		int a = 10;
		int b = 0;
	
		return (a/b);
	}
	private static int test2() throws Exception {
		return test1();
	}
	private static int test3() throws Exception {
		return test2();
	}
	
	public static void main(String[] args) throws Exception {
		
//		Temp2 t2 = new Temp2();//static 지우기
		System.out.println("div: " + Temp2.test3());
		
//		int div = 0;
//		try {
//			div = test3();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		System.out.println("div: " + div);
	}
}