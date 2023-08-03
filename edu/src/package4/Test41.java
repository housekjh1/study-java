package package4;

import java.util.Scanner;

public class Test41 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 단수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num <= 0) {
			System.out.println("잘못된 수를 입력하셨습니다.");
		}
		if (num > 9) {
			System.out.println("잘못된 수를 입력하셨습니다.");
		} else {
			int cnt = Integer.parseInt(args[(num-1)]);
			for (int i = 1; i <= 9; i++) {
				System.out.println(cnt + " * " + i + " = " + (cnt*i));
			}
		}
		
	}

}
