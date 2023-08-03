package com.ruby.java.ch02;

public class Test13 {

	public static void main(String[] args) {
		byte a = 0b00010001;
		byte b = 0b00100010;
		//byte x = (~a);
		
		int c = a & b;
		System.out.println(Integer.toBinaryString(c));
		
		int d = a | b;
		System.out.println(Integer.toBinaryString(d));
		
		int e = a ^ b;
		System.out.println(Integer.toBinaryString(e));
		
		int f = 12;
		int g = (~f) + 1;
		
		System.out.println(g);
		
		int h = f << 1;
		System.out.println(h);
		
		char ch = 'A';
		ch ^= (1 << 5);
		System.out.println(ch);

	}

}
