package com.ruby.java.ch02;

public class Test11 {

	public static void main(String[] args) {
		int a = 12;
		int b = -12;
		
		String aBit = Integer.toBinaryString(a);
		System.out.println("aBit = " + aBit);
		
		String bBit = Integer.toBinaryString(b);
		System.out.println("bBit = " + bBit);
		
		int c = 0x27;
		System.out.println("c = " + c);

	}

}
