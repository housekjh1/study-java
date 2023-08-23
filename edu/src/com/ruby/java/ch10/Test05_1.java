package com.ruby.java.ch10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test05_1 {
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("서울"); list.add("북경"); list.add("상해");
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i)+"\t");
		}
		
		list.add(1, "LA"); list.add("런던"); list.add("서울");
		
		List<String> list2 = Arrays.asList("북경", "상해");
		list.addAll(list2);
		
		Object obj[] = list.toArray();
		System.out.println("24 : " + Arrays.toString(obj));
		
		String cities[] = new String[0];
	}
}
