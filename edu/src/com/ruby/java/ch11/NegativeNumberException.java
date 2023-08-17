package com.ruby.java.ch11;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super("음수는 허용하지 않습니다.");
	}
}
