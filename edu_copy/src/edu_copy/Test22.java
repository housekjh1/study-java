package edu_copy;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		Scanner as = new Scanner(System.in);
		System.out.print("a : ");
		int a = as.nextInt();
		
		Scanner bs = new Scanner(System.in);
		System.out.print("b : ");
		int b = bs.nextInt();
		
		Scanner ops = new Scanner(System.in);
		System.out.print("op : ");
		String op = ops.next();
		
		switch(op) {
		case "+":
			System.out.println(a + b); break;
		case "-":
			System.out.println(a - b); break;
		case "*":
			System.out.println(a * b); break;
		case "/":
			System.out.println(a / b); break;
		default:
			System.out.println("잘못된 연산자 입니다.");
		}

	}

}
