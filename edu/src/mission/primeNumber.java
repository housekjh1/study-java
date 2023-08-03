package mission;

import java.util.Scanner;

public class primeNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		if (num <= 2) {
			System.out.println("더 큰수를 입력하세요.");
			return;
		}
		
		int i;
		int len = num / 2 + 1;
		for (i = 2; i < len; i++) {
			if (num % i == 0)
				break;
		}

		if(len <= i) {
			System.out.println("소수임");
			return;
		}
		System.out.println("소수아님");
	}

}
