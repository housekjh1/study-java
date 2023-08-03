package edu_copy;

import java.util.Scanner;

public class Test25_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Num : ");
		int num = sc.nextInt();
		int sum = sumMethod(num);
		System.out.println("Sum : " + sum);

	}

	public static int sumMethod(int num) {
		int sum = 0;
		for(int i = 0; i <= num; i+=2) {
			sum += i;
		}
		return sum;
	}
}
