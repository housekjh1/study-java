package com.ruby.java.ch09;

import java.util.Random;
import java.util.StringTokenizer;

public class Test11 {
	
	public static void main(String[] args) {
		
		Random r1 = new Random();
		System.out.println("난수 = " + r1.nextInt());
		System.out.println("난수 = " + r1.nextInt(10));
		System.out.println("난수 = " + r1.nextInt(10));
		System.out.println("난수 = " + r1.nextInt(10));
		System.out.println("난수 = " + r1.nextInt(10));
		System.out.println("난수 = " + r1.nextInt(10));
		
//		String s = "id=guest&name=Amy&pwd=1004";
//		StringTokenizer st = new StringTokenizer(s, "&");
//		while (st.hasMoreTokens()) {
//			System.out.println("토큰 수 = " + st.countTokens());
//			System.out.println(st.nextToken());
//			System.out.println(st.nextElement());
//		}
		
//		int i3 = Integer.parseInt("123");//문자열 변환
//		
//		int i = 123;
//		Integer obj6 = Integer.valueOf(i);//박싱
//		Integer obj7 = 22;
//		int nx = obj6.intValue();//언박싱
	}
}
