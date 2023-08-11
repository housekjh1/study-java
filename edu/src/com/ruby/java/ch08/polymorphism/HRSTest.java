package com.ruby.java.ch08.polymorphism;

abstract class Employee extends Object{//추상 클래스
	String name;
	int salary;
	public Employee() {//자동으로 추가
		super();//자동으로 추가(Object)
	}
	public abstract void calcSalary();//추상 메서드
	public void show() {
		System.out.println("name = " + name + "salary = " + salary);
	}
}

class Salesman extends Employee {
	int annual_sales;
	public Salesman() {//자동으로 삽입
		super();//자동으로 삽입
	}
	public void calcSalary() {
		System.out.println("세일즈맨");
	}
}

class Consultant extends Employee {
	int num_project;
	public void calcSalary() {
		System.out.println("컨설턴트");
	}
}

abstract class Manager extends Employee {
	int num_team;
	public void calcSalary() {//추상 메서드 구현
		System.out.println("매니저");
	}
}
class Director extends Manager {
	public void calcBonus() {
		System.out.println("이사");
	}
}
public class HRSTest {
	public static void calcTax(Employee e) {
		if (e instanceof Salesman) {
			Salesman s = (Salesman) e;//Type Casting
			System.out.println(e + "는 세일즈맨 객체 입니다.");
			System.out.println(s.annual_sales);
		}
		e.calcSalary();
		double tax = 0;
		if (e.getClass().getName() == "Director") {
			tax = e.salary * 0.2;
		} else {
			tax = e.salary * 0.1;
		}
		System.out.println("세금 : " + tax);
	}

	public static void main(String[] args) {
//		Employee e = new Employee();
//		Manager s2 = new Salesman();//다른 타입이므로 에러
		Salesman s = new Salesman();
		Employee e = new Salesman();
		Object o = new Salesman();
		Director d = new Director();
		Consultant c = new Consultant();
//		Manager m = new Manager();//추상 클래스이므로 객체생성 못함
		s.calcSalary();
		calcTax(s);//Dynamic Binding(동적 연결)
		calcTax(d);
		calcTax(c);
		s.toString();
//		if (s.equals(c))
	}
		
}
