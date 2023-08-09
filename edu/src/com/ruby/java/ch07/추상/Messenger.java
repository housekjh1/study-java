package com.ruby.java.ch07.추상;

public interface Messenger {
//	String name;//인터페이스에서 필드 선언은 안됨
	int MIN_SIZE = 1;//final 상수 값 처리(인터페이스에서 필드선언은 자동 상수처리)
	int MAX_SIZE = 104857600;//final
	
	public String getMessage();//추상 메서드 - abstract 사용하지 않음
	
	public void setMessage(String msg);
	
	public default void setLogin(boolean login) {
		System.out.println("로그인");
	}
	
	public static void getConnection() {//정적 메서드 Messenger.getConnection(); 객체가 없어도 사용가능
		System.out.println("network에 연결합니다.");
	}
	
}
