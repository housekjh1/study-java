package com.ruby.java.ch07.추상;

abstract class Employee {//추상 클래스
	String name;
	int salary;
	
	public abstract void calcSalary();//추상 메서드
	public void show() {
		System.out.println("name = " + name + "salary = " + salary);
	}
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("세일즈맨");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("컨설턴트");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {//추상 메서드 구현
		System.out.println("매니저");
	}
}

public class HRSTest {
	public static void main(String[] args) {
//		Employee e = new Employee();
		Salesman s = new Salesman();
//		Manager m = new Manager();//추상 클래스이므로 객체생성 못함
		s.calcSalary();
	}
		
}
