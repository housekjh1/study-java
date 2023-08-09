package com.ruby.java.ch07.상속;

public class Employee extends Person {
//	private String name;
//	private int age;
	private String dept;
	public Employee() {
//		super();//컴파일러가 자동으로 생성
		System.out.println("Employee 생성자 호출");
	}
	public Employee(String name, int age, String dept) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.dept = dept;
	}
	//public Employee() {super();} 객체 생성자를 자바 컴파일러가 자동으로 생성
	
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
	
	public String toString() {
//		return getName() + " : " + getAge() + " : " + dept;
//		return name + " : " + age + " : " + dept; private 필드이므로 오류
		return super.toString() + " dept = " + dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
		
}
