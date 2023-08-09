package com.ruby.java.ch07.상속;

public class Professor extends Person {
//	private String name;
//	private int age;
	private String subject;
	public Professor() {
//		super();//자동 삽입
		System.out.println("Professor 생성자 호출");
	}//컴파일러가 자동 삽입
	public Professor(String name, int age, String subject) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.subject = subject;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
		
}
