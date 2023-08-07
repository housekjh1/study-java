package mission;

import java.util.Scanner;

public class Exchange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하십시오. : ");
		int a = sc.nextInt();
		a = a / 1000 * 1000;
		System.out.println(a);
		
		int[] money = {50000, 10000, 5000, 1000};
		int b;
				
		for (int i = 0; i < money.length; i++) {
			b = a / money[i];
			a %= money[i];
			System.out.println(money[i] + "원 " + b + "장");
		}
	}

}
