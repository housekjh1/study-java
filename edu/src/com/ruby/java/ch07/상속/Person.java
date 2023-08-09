package com.ruby.java.ch07.상속;

public class Person {
	private final String ssn_ID = "1234";//초기화가 안되어 있으면 클래스 기본 생성자에서도 에러
	private String name;
	private int age;
	
	public void setssn_ID(String ssn_ID) {
//		this.ssn_ID = ssn_ID;//값을 변경하려는 의도이므로 에러
	}
//	public Person(String ssn_ID) {
//		this.ssn_ID = ssn_ID;//생성자로 초기화 작업을 해주는 동작이므로 오류가 안남
//	}
	
	public Person () {
		System.out.println("Person 생성자 호출");
	}
	public Person (String name) {
		this.name = name;
	}
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "name = " + name + " age = " + age;
	}
	
}
