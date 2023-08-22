package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {

	@Override
	public void print() {
		System.out.println("MyClass1");
	}

}

class MyClass2 implements MyInterface {

	@Override
	public void print() {
		System.out.println("MyClass2");
	}

}

public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}

	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {

			@Override
			public void print() {
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}

	public static void main(String[] args) {

		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print(); // MyClass1
		mc2.print(); // MyClass2

		MyInterface mi = new MyInterface() {

			@Override
			public void print() {
				System.out.println("익명 클래스로 구현");
			}

		};

		test(mc1); // MyClass1

		test(mi); // 익명 클래스로 구현
		mi.print(); // 익명 클래스로 구현

		(new MyInterface() {

			@Override
			public void print() {
				System.out.println("선언, 생성, 호출을 한 번에 처리");
			}
		}).print(); // 선언, 생성, 호출을 한 번에 처리

		MyInterface mi2 = test2();
		mi2.print(); // test2()메서드에서 반환된 MyInterface

		MyInterface m = () -> {
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
		};
		m.print(); // 메서드를 하나만 가지는 인터페이스 -> 함수형 인터페이스, 람다식으로 구현

	}
}
