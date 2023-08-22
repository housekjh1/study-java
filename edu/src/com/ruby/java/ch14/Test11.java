package com.ruby.java.ch14;

@FunctionalInterface
interface StringFunc2 {
	String modify(String s);
}

public class Test11 {
	
	String func(String s) {
		String result = "";
		char c;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == ',') {// 쉼표 찾기
				result += " ";// 쉼표를 공백으로 바꾸기
			}
			else {
				result += c;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Test11 obj = new Test11();
		StringFunc2 sf1 = obj::func;
		
		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		String result = sf1.modify(str);
		System.out.println(result);
		
		String str2 = "서울,북경,도쿄,뉴욕,발리";
		result = sf1.modify(str2);
		System.out.println(result);
	}
}
