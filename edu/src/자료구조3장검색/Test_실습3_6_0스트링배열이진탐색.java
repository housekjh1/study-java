package 자료구조3장검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;

public class Test_실습3_6_0스트링배열이진탐색 {

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData(data);
		System.out.println("=".repeat(105));
//		Arrays.sort(data);
		sortData(data);
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\n" + key + " linearSearch(): result = " + result);

		key = "배";
		result = binarySearch(data, key);
		System.out.println("\n" + key + " binarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\n" + key + " Arrays.binarySearch(): result = " + result);

	}

	private static int linearSearch(String[] data, String key) {
		int i = 0;
		while (true) {
			if (i >= data.length)
				return -1;
			else if (data[i] == key)
				return i;
			i++;
		}
	}

	private static int binarySearch(String[] data, String key) {
		int pl = 0;
		int pr = data.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (data[pc] == key)
				return pc;
			else if (data[pc].compareTo(key) < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		return -1;
	}

	private static void sortData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					String st = data[i];
					data[i] = data[j];
					data[j] = st;
				}
			}
		}

	}

	private static void showData(String[] data) {
		for (String st : data) {
			System.out.print("'" + st + "' ");
		}
		System.out.println();
	}

}
