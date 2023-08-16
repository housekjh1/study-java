package com.ruby.java.ch09;

import java.util.Arrays;

public class Test16 {
	public static void main(String[] args) {
		
		int score[] = {81, 52, 3, 14, 25, 66};
//		int score2[] = Arrays.copyOf(score, score.length);
		
		Arrays.sort(score);
		for (int num : score) {
			System.out.println(num);
		}
		
		String s1 = Arrays.toString(score);//배열을 스트링으로 바꿈
		System.out.println(s1);
		
		int i1 = Arrays.binarySearch(score, 14);//입력값의 인덱스 찾기
		System.out.println(i1);
	}
}
