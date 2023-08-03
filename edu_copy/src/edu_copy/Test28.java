package edu_copy;

import java.util.Scanner;

public class Test28 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		while (true) {
			System.out.print("Num : ");
			int cnt = sc.nextInt();
			if (cnt <= 0)	break;
			
			// A(all), O(odd), E(even)
			System.out.print("Flag(전체[A], 홀수[O], 짝수[E] : ");
			String flag = sc.next();
			
			int sum = 0;
			int a = 0;
			int b = 0;
			
			switch (flag) {
			
			case "A":
				a = 1; b = 1;				
					break;
				
			case "O":
				a = 1; b = 2;
					break;
				
			case "E":
				a = 2; b = 2;
					break;
				
			default:
				System.out.println("잘못된 flag 값입니다.");
				continue;
			}
			
			/* int a = 0;
			int b = 0;
			if (flag.equals("A")) {
				a = 1; b = 1;
			} else if (flag.equals("O")) {
				a = 1; b = 2;
			} else if (flag.equals("E")) {
				a = 2; b = 2;
			} else {
				continue;
			}
			*/
			for (int i = a ; i <= cnt ; i+=b) {
				sum += i;
			} 
			
			System.out.println("Sum : " + sum);
		}
		System.out.println("Good Bye!");
	}

}
