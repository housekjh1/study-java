package edu;

import java.util.Scanner; //ctrl + shift + o

public class Test19 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int score = 90;
		System.out.print("score:");
		int score = sc.nextInt();
		
		String result = "";
		
		if(score >= 60) {
			result = "합격";
		} else {
			result = "불합격";
		}
		System.out.println(result);
	}

}
