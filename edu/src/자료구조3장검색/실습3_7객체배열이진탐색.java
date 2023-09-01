package 자료구조3장검색;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit3 {
	String name;
	int price;
	String expire;

	public Fruit3(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "<" + name + ", " + price + ", " + expire + ">";
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}

class FruitNameComparator implements Comparator<Fruit3> {
	@Override
	public int compare(Fruit3 f1, Fruit3 f2) {
//		if (f1.name.compareTo(f2.name) != 0) {
		return f1.name.compareTo(f2.name);
//		}
//		if (Integer.compare(f1.price, f2.price) != 0) {
//			return Integer.compare(f1.price, f2.price);
//		}
//		return f1.expire.compareTo(f2.expire);
	}
}

public class 실습3_7객체배열이진탐색 {

	private static void sortData(Fruit3[] arr, Comparator<Fruit3> cc_price) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc_price.compare(arr[i], arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void swap(Fruit3[] arr, int ind1, int ind2) {
		Fruit3 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(Fruit3[] arr, FruitNameComparator cc) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void showData(Fruit3[] arr) {
		System.out.println();
		for (Fruit3 fx : arr) {
			System.out.print(fx + " ");
		}
		System.out.println();
	}

	// 교재 111 페이지 참조하여 구현
	static int binarySearch(Fruit3[] a, Fruit3 f, Comparator<Fruit3> cc) {
		int pl = 0;
		int pr = a.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;

			if (cc.compare(a[pc], f) == 0) {
				return pc;
			} else if (cc.compare(a[pc], f) < 0) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Fruit3[] arr = {
			new Fruit3("사과", 200, "2023-5-8"), 
			new Fruit3("키위", 500, "2023-6-8"),
			new Fruit3("오렌지", 200, "2023-7-8"), 
			new Fruit3("바나나", 50, "2023-5-18"),
			new Fruit3("수박", 880, "2023-5-28"), 
			new Fruit3("체리", 10, "2023-9-8")
			};
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		FruitNameComparator cc = new FruitNameComparator();
//		Arrays.sort(arr, cc);
		sortData(arr, cc);
		System.out.println("\n정렬 후 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit3에 compareTo()가 있어도 람다식 우선 적용, 람다함수, 익명함수
		System.out.println("\n람다식 정렬(가격)후 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, new Comparator<Fruit3>() {// 익명 클래스
			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr);
		// *
		Comparator<Fruit3> cc_name = new Comparator<Fruit3>() {// 익명클래스 사용

			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
				return a1.name.compareTo(a2.name);
			}

		};
		Comparator<Fruit3> cc_price = new Comparator<Fruit3>() {

			@Override
			public int compare(Fruit3 a1, Fruit3 a2) {
//				if(Integer.compare(a1.price, a2.price) != 0) {
				return Integer.compare(a1.price, a2.price);
//				}
//				return a1.expire.compareTo(a2.expire);
			}

		};

		Fruit3 newFruit3 = new Fruit3("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit3, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit3, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit3, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit3, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	
	}
}
