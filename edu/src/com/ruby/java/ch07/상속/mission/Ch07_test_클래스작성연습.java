package com.ruby.java.ch07.상속.mission;

//7장 실습할 과제로 부과
class Person {
	int pid;
	String name;
	int age;
	//pid, name, age
	public Person(int pid, String name, int age) {
		this.pid = pid; this.name = name; this.age = age;
	}
	public String toString() {
		return "pid : " + pid + " name : " + name + " age : " + age;
	}
}

class Student extends Person {
	int sid;
	String dept;
	int year;
	//sid, dept, year
	public Student(int pid, String name, int age, int sid, String dept, int year) {
		super(pid, name, age);
		this.sid = sid; this.dept = dept; this.year = year;
	}	
	public String toString() {
		return super.toString() + " sid : " + sid + " dept : " + dept + " year : " + year;
	}
}
class Employee extends Person {
	int eno;
	String dept;
	int salary;
	//eno, dept, salary
	public Employee(int pid, String name, int age, int eno, String dept, int salary) {
		super(pid, name, age);
		this.eno = eno; this.dept = dept; this.salary = salary;
	}
	public String toString() {
		return super.toString() + " eno : " + eno + " dept : " + dept + " salary : " + salary;
	}
}
public class Ch07_test_클래스작성연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person arr[] = new Person[5];
		arr[0] = new Student(230810, "Hong", 20, 401, "Computer", 2023);
		arr[1] = new Employee(230811, "Lee", 21, 402, "Server", 5000);
		arr[2] = new Employee(230812, "Kim", 22, 403, "Sales", 3000);
		arr[3] = new Student(230813, "Jung", 23, 404, "Math", 2022);
		arr[4] = new Employee(230814, "Park", 24, 405, "Engineer", 4000);
		
		for(Person p : arr) {
			System.out.println(p.toString());
		}

	}

}
