package com.ruby.java.ch06;

//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
* 생성자 함수 구현 - this(); 호출 사용
* static 데이터 멤버 사용
* static 멤버 함수 구현
* toString() 함수 구현과 사용
* 객체 배열 사용
*/
public class Chap06_test_생성자 {
	static int countStudents;// 객체수, [static] : 객체가 없어도 메인에서 실행이 가능함
	int sid;// 학번
	String sname; // 학생 이름
	String city; // 주소 도시
	public Chap06_test_생성자(int sid, String sname, String city) {
		this.sid = sid;
		this.sname = sname;
		this.city = city;
	}

	void showStudent() {
		System.out.print("객체: ");
		System.out.println("객체출력: " + toString());
//		this.toString();
		System.out.println();
	}

	static void showNumberObjects() {// 생성된 객체수를 출력한다.

	}

// 생성자를 구현한다.
public static void main(String[] args) {

	countStudents = 0;
	Chap06_test_생성자.countStudents++;
//	sid = 0;
	Chap06_test_생성자 s = new Chap06_test_생성자(11, "Hong", "Seoul");
	s.sid = 10;
	s.sname = "hello";
	s.showStudent();
	showNumberObjects();
//	int [] a = new int [5];
//	Student arry[] = new Student[5];
//	showNumberObjects();
//	arry[0] = new Student();
//	arry[1] = new Student(202301);
//	arry[2] = new Student(202302, 'Hong');
//	arry[3] = new Student(202303, 'Lee', 'Busan');
//	showNumberObjects();
//	}
//	for () {
//		arry[i].showStudent();//생성된 객체 모두를 출력한다.
//	}
}

}
