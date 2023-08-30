package 자료구조3장검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;

public class Test_실습3_4정수배열이진탐색 {

	static void inputData(int[] data) {
		Random rd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rd.nextInt(50) + 1;
		}
	}

	static int linearSearch(int[] data, int key) {
		int i = 0;
		while (true) {
			if (i == data.length - 1)	return -1;
			else if (data[i] == key)	return i;
			i++;
		}
	}

	static int binarySearch(int[] a, int key) {
		int pl = 0;
		int pr = a.length - 1;
		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key)	return pc;
			else if (a[pc] < key)	pl = pc + 1;
			else if (a[pc] > key)	pr = pc - 1;
		} while (pl <= pr);
		return -1;
	}

	static void showData(int[] data) {
		for (int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static void sortData(int[] data) {
//		Arrays.sort(data);
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					int t = data[i];
					data[i] = data[j];
					data[j] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
//		Arrays.sort(data);
		sortData(data);
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println();
		System.out.println("key: " + key +"\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("key: " + key + "\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
		System.out.println("key: " + key + "\nArrays.binarySearch(): result = " + idx);

	}

}
