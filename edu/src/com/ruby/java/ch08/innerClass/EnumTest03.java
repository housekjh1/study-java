package com.ruby.java.ch08.innerClass;

import java.util.Scanner;

//자료구조시에 사용
enum Mandarin3 {//이쪽 다시 만들어보기
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);

	private int price;
	//enum의 생성자: enum 상수마다 생성자를 호출하여 초기화한다.
	Mandarin3(int p) {
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}

	int getPrice() {
		return price;
	}
	
	static Mandarin3 MandarinAt(int idx) {
		for (Mandarin3 m : Mandarin3.values())
			if (m.ordinal() == idx)
				return m;
		return null;
	}
}



public class EnumTest03 {
	static Scanner stdIn = new Scanner(System.in);
	static Mandarin3 selectMenu() {
		int key;
		do {
			for (Mandarin3 m : Mandarin3.values()) {
				System.out.print(m.ordinal() + ".");
				System.out.println(" " + m + "(" + m.getPrice() + ")");
			}
			System.out.println("선택: ");
			key = stdIn.nextInt();
		} 
		while(key < Mandarin3.금귤.ordinal() || key > Mandarin3.황금향.ordinal());
		
		return Mandarin3.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin3 choice = selectMenu();
		
		//System.out.println("enum 시작::");
		//Mandarin ma = Mandarin.한라봉;//enum 생성자가 호출되어 실행
		System.out.print("  순서: "+ choice.ordinal());
		System.out.println(" 이름: "+ choice.name() + ", 가격: " + choice.getPrice());

		/*
		System.out.println("황금향과 비교: "+ ma.compareTo(Mandarin.레드향));
		Mandarin m2	= Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m : list)
			System.out.println(m + ":" + m.getPrice());
			
			*/
	}
}
