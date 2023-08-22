package com.ruby.java.ch14;

import java.util.Scanner;

interface Verify2 {
	boolean check(int n, int d);
}

public class Test04 {
	public static void main(String[] args) {

//		Verify2 vf = (n,d) -> (n%d) == 0;
//		System.out.println(vf.check(24, 3));
		Scanner sc = new Scanner(System.in);
		Verify2 vf2 = (n, d) -> (n % d) == 0;
		while (true) {

			int n, d;
			System.out.print("숫자를 입력하세요.: ");
//			int n = sc.nextInt();
//			if (n == 0) break;
			if((n = sc.nextInt()) == 0) break;
			System.out.print("숫자를 입력하세요.: ");
//			int d = sc.nextInt();
//			if (d == 0) break;
			if((d = sc.nextInt()) == 0) break;
//			if (n == 0 | d == 0) {
//				break;
//			} else {
//				
//			System.out.println(vf2.check(n, d) + ".");
			if (vf2.check(n, d)) System.out.println("배수입니다.");
			else 				System.out.println("배수가 아닙니다.");
//			}
		}
		System.out.println("Done.");
	}
}
