package com.ruby.java.ch02;

public class Test3 {
	public static void main(String[] args) {
		boolean isMarried;
		isMarried  = false;
		System.out.println("isMarried = " + isMarried);

		char gender;
		gender = 'M';
		//gender = 'Male';
		System.out.println("gender = " + gender);
		char c = '\u0058';
		System.out.println("c = " + c);
		
		int num;
		String greeting = "Good Morning";
		System.out.println("greeting = " + greeting);
		
		long totalSales;
		//num이 4바이트이고 totalSales가 8바이트인지 확인하고 싶다
		System.out.println("int타입의 길이 = " + Byte.SIZE);
	}
}
