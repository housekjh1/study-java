package 자료구조5장재귀;

//실습 5-2
//유클리드 호제법으로 최대공약수를 구함

import java.util.Scanner;

//--- 정수 x, y의 최대공약수를 구하여 반환 ---//
public class 실습5_2EuclidGCD {

	static int gcd(int x, int y) {
		System.out.println("x = " + x + ", y = " + y);
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("두 정수의 최대공약수를 구합니다.");

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		System.out.print("정수를 입력하세요 : ");
		int y = stdIn.nextInt();

		System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
	}
}
