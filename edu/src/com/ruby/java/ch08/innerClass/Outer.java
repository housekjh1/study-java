package com.ruby.java.ch08.innerClass;

public class Outer {
	class Student {
		
	}
	static class StaticClass {
		private static int a;
		
		public void setA(int a) {
			this.a = a;
		}
	}
	public static void main(String[] args) {
//		Outer o = new Outer();
		Outer.StaticClass.a = 0;
	}
}
