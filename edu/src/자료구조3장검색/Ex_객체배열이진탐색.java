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

class Fruit32 {
	String name;
	int price;
	String expire;

	public Fruit32(String name, int price, String expire) {
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

class FruitNameComparator2 implements Comparator<Fruit32> {

	public int compare(Fruit32 f1, Fruit32 f2) {
		// 구현
		if (f1.name.compareTo(f2.name) != 0)
			return f1.name.compareTo(f2.name);
		if (f1.price != f2.price) {
			if (f1.price > f2.price)
				return 1;
			else
				return -1;
		}
		return f1.expire.compareTo(f2.expire);
	}
}

public class Ex_객체배열이진탐색 {

	private static void sortData(Fruit32[] arr, Comparator<Fruit32> cc_price) {
		// 구현
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc_price.compare(arr[i], arr[j]) > 0)
					swap(arr, i, j);
			}
		}
	}

	static void swap(Fruit32[] arr, int ind1, int ind2) {
		Fruit32 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(Fruit32[] arr, FruitNameComparator2 cc) {
		// 구현
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) > 0)
					swap(arr, i, j);
			}
		}
	}

	static void showData(Fruit32[] arr) {
		System.out.println();
		for (Fruit32 fx : arr) {
			System.out.print(fx + " ");
		}
		System.out.println();
	}

	// 교재 111 페이지 참조하여 구현
	static int binarySearch(Fruit32[] a, Fruit32 f, Comparator<Fruit32> cc) {
		// 구현
		int pl = 0, pr = a.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (cc.compare(a[pc], f) == 0)
				return pc;
			else if (cc.compare(a[pc], f) > 0)
				pr = pc - 1;
			else
				pl = pc + 1;
		}
		return -1;
	}

	public static void main(String[] args) {

		Fruit32[] arr = { new Fruit32("사과", 200, "2023-5-8"),
							new Fruit32("키위", 500, "2023-6-8"),
							new Fruit32("오렌지", 200, "2023-7-8"),
							new Fruit32("바나나", 50, "2023-5-18"),
							new Fruit32("수박", 880, "2023-5-28"),
							new Fruit32("체리", 10, "2023-9-8") };
		System.out.println("\n정렬전 객체 배열: ");
		showData(arr);
		FruitNameComparator2 cc = new FruitNameComparator2();
		// Arrays.sort(arr, cc);
//		 sortData(arr, cc);
//		 showData(arr);
		/*
		 * Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit3에
		 * compareTo()가 있어도 람다식 우선 적용 System.out.println("\n람다식 정렬(가격)후 객체 배열: ");
		 * showData(arr);
		 */
		// *
		Arrays.sort(arr, new Comparator<Fruit32>() {
			@Override
			public int compare(Fruit32 a1, Fruit32 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr);
		// *
		Comparator<Fruit32> cc_name = new Comparator<Fruit32>() {// 익명클래스 사용
			// 구현
			@Override
			public int compare(Fruit32 f1, Fruit32 f2) {
				return f1.name.compareTo(f2.name);
			}
		};
		Comparator<Fruit32> cc_price = new Comparator<Fruit32>() {
			// 구현
			public int compare(Fruit32 f1, Fruit32 f2) {
				if (f1.price > f2.price)
					return 1;
				else if (f1.price == f2.price)
					return 0;
				else
					return -1;
			}
		};

		Fruit32 newFruit32 = new Fruit32("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit32, cc_name);
		System.out.println("\nArrays.binarySearch("+newFruit32+") 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit32, cc_name);
		System.out.println("\nbinarySearch("+newFruit32+") 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit32, cc_price);
		System.out.println("\nArrays.binarySearch("+newFruit32+") 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit32, cc_price);
		System.out.println("\nbinarySearch("+newFruit32+") 조회결과::" + result3);
		// */
	}
}
