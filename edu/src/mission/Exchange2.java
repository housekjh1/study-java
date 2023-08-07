package mission;

import java.util.Scanner;

public class Exchange2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하세요.: ");
		int a = sc.nextInt();
		
		int[] money = {50000, 10000, 5000, 1000};
		int b = a / 1000 * 1000;
		int c;
		
		for (int i = 0; i < money.length; i++) {
			c = b / money[i];
			b %= money[i];
			
			System.out.println(money[i] + "원 " + c + "장");
		}
	}

}
