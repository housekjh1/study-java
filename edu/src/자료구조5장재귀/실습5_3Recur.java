package 자료구조5장재귀;

//실습 5-3  재귀 알고리즘

//재귀에 대한 이해를 돕는 순수 재귀 메서드

import java.util.Scanner;

//--- 순수 재귀 메서드 ---//
public class 실습5_3Recur {
	static void recur(int n) {
		if (n > 0) {
			System.out.println("recur(" + n + " - 1)");
			recur(n - 1);
			System.out.println(n);
			System.out.println("recur(" + n + " - 2)");
			recur(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
