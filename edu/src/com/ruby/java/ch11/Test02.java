package com.ruby.java.ch11;

public class Test02 {
	
	public static void main(String[] args) {
		
//		try {
//			System.out.println("1");
//			System.out.println("2");
//			System.out.println("3");
//		} catch (Exception e) {
//			System.out.println("오류 발생: " + e.getMessage());
//		} finally {
//			System.out.println("OK");
//		}
//		System.out.println("4");
		
		try {
			System.out.println("1");
			int a = 10;
			int b = 0;
			int div = a/b;
			
			String s = null;
			s.length();
			
			System.out.println("2");
			System.out.println("3");
		} catch (ArithmeticException e2) {
			System.out.println("오류 발생: " + e2.getMessage());
//		} catch (Exception e3) {
//			System.out.println("오류 발생: " + e3.getMessage());
		} finally {
			System.out.println("OK");
		}
		System.out.println("4");
	}
}
