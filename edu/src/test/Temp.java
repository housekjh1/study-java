package test;

public class Temp {
	
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
	
	public static void main(String[] args) {
		int div = 0;
		try {
			div = test3();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("div: " + div);
		
//		int a = 10;
//		int b = 0;
//		
//		int div = a/b;//에러 발생으로 이 라인에서 프로그램 종료
//		System.out.println("div: " + div);
			
//		int div = 0;
//		
//		try {
//			int a = 10;
//			int b = 0;
//			
//			div = a/b;
//		} catch (Exception e) {
//			e.printStackTrace();
////			System.out.println(e.getMessage());
//		}
//		
//		System.out.println("div: " + div);
	}
}
