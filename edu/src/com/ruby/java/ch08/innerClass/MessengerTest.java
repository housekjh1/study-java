package com.ruby.java.ch08.innerClass;
//class GalaxyMessenger implements Messenger {//익명 클래스 생성 시 인터페이스 상속 생략 가능
	
	
//	public void changeKeyboard() {
//		System.out.println("키보드 아이콘 터치 후 키보드를 변경합니다.");
//	}
//}
public class MessengerTest {
	public static void main(String[] args) {
		Messenger test = new Messenger() {//익명 클래스 생성
			public String getMessenger() {//추상 메서드 본문을 구현
				return "galaxy";
			}
			public void setMessenger(String msg) {
				System.out.println("galaxy에서 메시지를 설정합니다.: " + msg);
			}
		};
//		GalaxyMessenger galaxy = new GalaxyMessenger();
		test.getMessenger();
		test.setMessenger("hello");
		System.out.println(test.getMessenger());
	}
}
