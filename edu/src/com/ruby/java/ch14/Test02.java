package com.ruby.java.ch14;

@FunctionalInterface
interface Multiply {
	double getValue();
//	void test();
}

public class Test02 {
	public static void main(String[] args) {

		Multiply m;
		
		Multiply mf = new Multiply() {
			public double getValue() {
				return 3.14 * 2;
			}
		};
		
		System.out.println(mf.getValue());
		
		m = () -> 3.14 * 2;
		System.out.println(m.getValue());

		m = () -> 10 * 3;
		System.out.println(m.getValue());
	}
}
