package 자료구조5장재귀;

//실습 5-4

//재귀에 대한 이해를 돕는 순수 재귀 메서드(꼬리 재귀를 제거)

import java.util.Scanner;

class 실습5_4RecurX1 {
//--- 꼬리 재귀를 제거한 recur ---//
	static void recur(int n) {
		while (n > 0) { // recur(n-2) 호출을 while 로 변경
			System.out.println("recur(" + n + " - 1);");
			recur(n - 1);
			System.out.println(n);
			System.out.println("n = " + n + " - 2;");
			n = n - 2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
