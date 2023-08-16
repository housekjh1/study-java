package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
//		int[] num = new int[10];
//		for (int i = 0; i < num.length; i++) {}
		Object arr[] = new Object[10];//배열 자체가 메모리(heap)에 연속된 공간 할당
		String s = "java";
		Integer i1 = 123;
		arr[0] = s;
		arr[1] = i1;
//		arr[0].
//		int len = arr[0].length();//Object에 length()가 없다
		int len = ((String) arr[0]).length();//타입 캐스팅으로 .length() 사용가능

		ArrayList lst = new ArrayList();//배열과 비슷하나 중간에 데이터 추가가 가능함
		String s2 = "java";
		Integer i2 = 123;
		
		lst.add(s2);
		lst.add(i2);
//		lst.add(1, i2);//지정 인덱스에 데이터 추가
//		lst.remove(4);//지정 인덱스에 데이터 삭제 //처리 성능이 좋지않아 실시간 처리는 어려워 전자정부, 대민서비스 등에서만 사용 //방산시스템은 C/C++ 코딩
//		 lst. //. 다음에 나타나는 메소드를 확인
//		 int len = (lst.get(0)).length();//lst(ArrayList)의 리턴타입인 Object에 length()가 없음
		int len2 = ((String) lst.get(0)).length();

		System.out.println("len2 = " + len2);

		ArrayList<String> list = new ArrayList<>();

		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");
		int len12 = list.get(0).length();
//		list.add(10);

		for (String element : list) {
			System.out.print(" " + element);
		}
		System.out.println();
		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");
		System.out.println("1 : " + list);
		System.out.println("list.size() = " + list.size());

		list.add(1, "LA");
		print(2, list);

		// int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));

		// boolean remove(Object o)
		list.remove("LA");// 우측 객체가 좌로 이동하는 효과
		// list.remove // Object o = "LA";//"LA"은 문자열 literal이고 String class의 인스턴스로 처리된다
		// String s; s.String
		Object obj2 = "LA";// obj는 Object의 메소드만 사용 가능하다.
		print(5, list);

		// E remove(int index)
		list.remove(2);
		print(6, list);

		// boolean contains(Object o)
		System.out.println("7 : " + list.contains("LA"));// boolean contains(Object o)를 사용한다

		// Object[] toArray()
		Object obj[] = list.toArray();// list를 배열로 변경 - Object[] toArray()
		System.out.println(obj.toString());
		System.out.println("8 : " + obj);// obj는 참조 변수이고 이를 toString()으로 변환 //Object.toString()과는 다름
		System.out.println("8 : " + Arrays.toString(obj));// 배열의 원소들을 스트링으로 변화
		// <T> T[] toArray(T[] a)
		String cities[] = new String[5];
		cities = list.toArray(cities);// list를 배열로 변경 - 배열의 크기를 list 크기로 자동 조정
		System.out.println("9 : " + Arrays.toString(cities));

		// void clear()
		list.clear();
		print(10, list);

		// boolean isEmpty()
		System.out.println("11: " + list.isEmpty());

		list.add("파리");
		list.add("방콕");
		list.add("LA");

		// Arrays 클래스의 static <T> List<T> asList(T... a)
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해");// asList()는 배열을 입력받아 리스트를 만든다
		print(12, list2);

		// boolean addAll(Collection<? extends E> c) - ?는 wild card 사용
		list.addAll(list2);
		print(13, list);

		// boolean containsAll(Collection<?> c)
		System.out.println("14: " + list.containsAll(list2));

		// boolean retainAll(Collection<?> c)
		list.retainAll(list2);
		print(15, list);

		// boolean removeAll(Collection<?> c)
		list.removeAll(list2);
		print(16, list);
	}

	static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);// 스트링으로 타입 변환후 toString() 호출하여 실행
		// System.out.println(n + " : " + list.toString());//동일한 효과
	}
}
