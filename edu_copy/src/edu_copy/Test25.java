package edu_copy;

import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {
		
		Scanner as = new Scanner (System.in);
		System.out.print("Value : ");
		int a = as.nextInt();
		int sum = 0;
		
		for(int i = 0; i <= a; i+=2) {
			sum += i;
			//System.out.println(i);
		}
		System.out.println("Sum : " + sum);
	}

}
