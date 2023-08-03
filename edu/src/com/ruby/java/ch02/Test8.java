package com.ruby.java.ch02;

public class Test8 {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int c = a, d = b;
		
		if (a < b & c < d)
			System.out.println("a가 작다");
		else
			System.out.println("b가 작다");
		
		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(a >= b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);
		
	}

}
