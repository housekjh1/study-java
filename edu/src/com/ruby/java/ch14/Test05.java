package com.ruby.java.ch14;

import java.util.Scanner;

@FunctionalInterface
interface NumberFunc {
	int func(int n, int d);
}

public class Test05 {

	public static void main(String[] args) {

//		NumberFunc sum = (n) -> {
//			int result = 0;
//			for (int i = 0; i <= n; i++) {
//				result += i;
//			}
//			return result;
//		};
//		
//		System.out.println("1부터 10까지의 합 : " + sum.func(10));
//		System.out.println("1부터 100까지의 합 : " + sum.func(100));

		// 두 수를 입력
		// 입력값을 비교하여 앞 수가 더 큰 수라면 자리 바꾸고 출력
		// 0이 들어오면 프로그램 종료

		Scanner sc = new Scanner(System.in);

		NumberFunc sum = (i1, i2) -> {
			int result = 0;
			
			for (int i = i1; i <= i2; i++) {
				result += i;
			}
			return result;
		};

		int a, b;

		while (true) {
			System.out.print("수를 입력하세요.: ");
			if ((a = sc.nextInt()) == 0)
				break;
			System.out.print("수를 입력하세요.: ");
			if ((b = sc.nextInt()) == 0)
				break;
			
			if (a > b) {
				int t = b;
				b = a;
				a = t;
			}
			System.out.println(a + "부터 " + b + "까지의 합: " + sum.func(a, b));
		}
		System.out.println("Done.");
	}
}
