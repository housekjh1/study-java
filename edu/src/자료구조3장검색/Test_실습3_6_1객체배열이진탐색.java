package 자료구조3장검색;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData p) {
		return this.name.compareTo(p.name);
	}

	@Override
	public String toString() {
		return "<" + name + ", " + height + ", " + vision + ">";
	}

}

public class Test_실습3_6_1객체배열이진탐색 {

	static int count = 0;
	public static void main(String[] args) {
		PhyscData[] data = {
			new PhyscData("홍길동", 162, 0.3), 
			new PhyscData("홍동", 164, 1.3),
			new PhyscData("홍길", 152, 0.7), 
			new PhyscData("김홍길동", 172, 0.3), 
			new PhyscData("길동", 182, 0.6),
			new PhyscData("김길동", 167, 0.2), 
			new PhyscData("박길동", 167, 0.5)
			};
		showData(data);
//		Arrays.sort(data);
		sortData(data);
//		Arrays.binarySearch(data, key);
		System.out.println("=".repeat(117));
		showData(data);
		PhyscData key = new PhyscData("홍길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\n" + key + " linearSearch(): result = " + result + " count: " + count);
		count = 0;
		key = new PhyscData("홍길동", 167, 0.5);
		result = binarySearch(data, key);
		System.out.println("\n" + key + " binarySearch(): result = " + result + " count: " + count);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\n" + key + " Arrays.binarySearch(): result = " + idx);
	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		int i = 0;
		while (true) { 
			count++;
			if(i >= data.length) return -1;
			else if(data[i].compareTo(key) == 0) return i;
			i++;
		}
	}
 	
	private static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length-1;
		while(pl <= pr) {
			count++;
			int pc = (pl + pr) / 2;
			if (data[pc].compareTo(key) == 0) return pc;
			else if (data[pc].compareTo(key) < 0) pl = pc + 1;
			else pr = pc - 1;
		}
		return -1;
	}

	public static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}

	private static void swap(PhyscData[] data, int i, int j) {
		PhyscData pd = data[i];
		data[i] = data[j];
		data[j] = pd;
	}

	static void showData(PhyscData[] arr) {
		for (PhyscData fruit : arr) {
			System.out.print(fruit + " ");
		}
		System.out.println();
	}

}
