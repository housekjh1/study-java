package com.ruby.java.ch11;

class MinusNumberException extends Exception {
	public MinusNumberException() {
		super("음수는 허용하지 않습니다.");
	}
}

public class Test05_1 {
	int battery = 0;
		
	public void charge(int time) {
		if (time < 0) {
			time = 0;
			try {
				throw new MinusNumberException();
			} catch (MinusNumberException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		battery += time;
		System.out.println("현재 배터리: " + battery);
	}
	
	public static void main(String[] args) {
		
		Test05 test = new Test05();
		test.charge(30);
		test.charge(20);
		test.charge(-10);
	}
}
