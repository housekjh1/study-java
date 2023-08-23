package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;

public class Test06 {
	public static void main(String[] args) {

		String word[] = { "BUMBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER" };
		String meaning[] = { "꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다" };

		HashMap<String, String> dic = new HashMap<String, String>();
		for (int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		System.out.println(dic);// {HEAVEN=천국, BUMBLEBEE=꿀벌과에 속하는 호박벌, WONDER=호기심이 들다, ALTHOUGH=그럼에도 불구하고}
		System.out.println(dic.size());// 4

		System.out.println(dic.keySet());// [HEAVEN, BUMBLEBEE, WONDER, ALTHOUGH]
		System.out.println(dic.values());// [천국, 꿀벌과에 속하는 호박벌, 호기심이 들다, 그럼에도 불구하고]
		
		System.out.println(dic.get("ALTHOUGH"));
		System.out.println();
		Iterator<String> keys = dic.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
		System.out.println();
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
		
//		System.out.println("HEAVEN : " + dic.get("HEAVEN"));// HEAVEN : 천국
//		dic.replace("HEAVEN", "아주 행복한 감정");
//		System.out.println("HEAVEN : " + dic.get("HEAVEN"));// HEAVEN : 아주 행복한 감정
//		dic.put("HEAVEN", "이상적인 세상");
//		System.out.println("HEAVEN : " + dic.get("HEAVEN"));// HEAVEN : 이상적인 세상
//
//		System.out.println(dic.containsKey("BUMBLEBEE"));// true
//		System.out.println(dic.containsValue("자장가"));// false
//
//		dic.remove("HEAVEN");
//		System.out.println(dic.containsKey("HEAVEN"));// false
//
//		dic.clear();
//		System.out.println(dic.isEmpty());// true
//		System.out.println(dic.size());// 0
	}
}
