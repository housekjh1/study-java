package 자료구조2장기본자료구조;

public class Test_실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData(data);
		sortData(data);
		showData(data);
	}

	static void showData(String[] arr) {
		for (String s : arr) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}

	static void swap(String[] arr, int ind1, int ind2) {
		String s = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = s;
	}

	static void sortData(String[] arr) {// 객체 비교를 위해 arr[i].compareTo() 사용
//		List<String> L = new ArrayList<>();
//		for (int i = 0; i < arr.length; i++) {
//			L.add(arr[i]);
//		}
//		Collections.sort(L);
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = L.get(i);
//		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
}
