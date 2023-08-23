package com.ruby.java.ch10;

import java.util.Map;
import java.util.TreeMap;

public class Test09 {
	public static void main(String[] args) {
		
		TreeMap<String, String> users = new TreeMap<String, String>();
		
		users.put("20080319", "김푸름");
		users.put("20070620", "김하늘");
		users.put("20050817", "오정임");
		users.put("20120728", "김유빈");
		users.put("20120924", "김용빈");
		
		System.out.println(users);// key를 기준으로 정렬해서 출력, Tree의 특성 -> 작으면 앞으로 크면 뒤로
		// binary search tree -> TL < K < TR,  
		
		Map.Entry<String, String> entry = null;
		
		entry = users.firstEntry();
		System.out.println("입사일자가 가장 빠른 사람 " + entry);
		
//		entry = users.lastEntry();
//		print("입사일자가 가장 늦은 사람", entry);
//		
//		entry = users.lowerEntry("20121231");
//		print("2012년도에 가장 늦게 입사한 사람", entry);
		
//		entry = users.higherEntry("20120101");
//		print("2012년도에 가장 빠르게 입사한 사람", entry);
		
//		while()
	}
}
