
package com.ruby.java.ch10;

//iterator 사용
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Employee1 {
	String name;
	int age;
	int height;
	int weight;
	char blood_type;
	String email;

	public Employee1(String name, int age, int height, int weight, char blood_type, String email) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.blood_type = blood_type;
		this.email = email;
	}

	public Employee1() {
	}

	public String toString() {
		return name + " : " + age + " : " + height + " : " + weight + " : " + blood_type + " : " + email;
	}
}

class EmpComparator1 implements Comparator<Employee1> {
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.name.compareTo(e2.name);
	}
}

public class Test02_1 {

	public static void main(String[] args) {
		// page 459 그림
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		//
		Employee e10 = new Employee();

		// page 460 그림
		Employee[] arr = new Employee[5];
		arr[0] = new Employee();
		//
		arr[4] = new Employee();

		int[] num = new int[5];
		num[0] = 10;
		num[1] = 20;
		num[2] = 30; // num[1] = 15;// 삽입하려면

		Object arr2[] = new Object[10];
		ArrayList lst = new ArrayList(); // 크기가 10인 리스트를 생성
		String s = "java";
		Integer ix = 123;
		arr2[0] = s;
		arr2[1] = ix;
		// int len = arr2[0].length();//에러이다 arr2[0].에 나타나는 메소드는 Object 메소드만 있다
		int len2 = ((String) arr2[0]).length();

		lst.add(s);
		lst.add(ix);
		// int len3 = list.get(0).length();//오류 > list.get(0).은 Object이기 때문이다.
		int len4 = ((String) lst.get(0)).length();

		// 페이지 468
		List<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		int len5 = list.get(0).length();// list.get(0).은 String을 반환한다 이유는 생성자에서 T가 String으로 선언
		// E get(int index) >> generic으로 선언된 데이터 타입이므로

		for (String element : list) {
			System.out.print(element + " ");
		}
		System.out.println();

		for (int i = 0; i < list.size(); i++)
			System.out.print(" " + list.get(i));

		System.out.println("\n==============");
		System.out.println("1: " + list.toString());// ArrayList에 override된 메소드

		Iterator<String> iter = list.iterator();// iterator()는 iterator<String> 객체를 반환, iter 객체는 list의 첫 번째를 가리킴
		// 480페이지 1번째 문단
		while (iter.hasNext()) {// "서울" 값이 있으면 true
			System.out.print(iter.next() + " ");// "서울" 값을 반환 후 다음 엘리먼트를 가리킴
		}
		System.out.println();
		ArrayList<Employee1> elist = new ArrayList<>();
		elist.add(new Employee1("kim", 1, 2, 3, 'A', "kim@gmail.com"));
		elist.add(new Employee1("hong", 11, 12, 13, 'B', "hong@gmail.com"));
		elist.add(new Employee1("Choi", 12, 62, 23, 'O', "Choihong@gmail.com"));
		elist.add(new Employee1("han", 21, 72, 33, 'A', "hanhong@gmail.com"));
		elist.add(new Employee1("Go", 31, 82, 43, 'B', "gohong@gmail.com"));
//		Collections.sort(elist, new EmpComparator1());
		elist.sort(new EmpComparator1());//컬렉션은 .sort 사용
		System.out.println("정렬 후: ");
		for (Employee1 ee : elist)
			System.out.println(ee.toString());
		System.out.println();
		Employee1[] emparr = new Employee1[elist.size()];
		elist.toArray(emparr);
		Arrays.sort(emparr, new EmpComparator1());//배열은 Arrays의 sort 사용

		for (Employee1 ee2 : emparr)
			System.out.println(ee2.toString());
	}
}