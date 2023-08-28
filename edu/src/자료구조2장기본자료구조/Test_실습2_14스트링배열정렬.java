package 자료구조2장기본자료구조;

public class Test_실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData(data);
		System.out.println("\nsort 후\n");
		sortData(data);
//		Arrays.sort(data);// 배열이기 때문에 Arrays.sort()로 정렬 가능
		showData(data);
	}

	static void showData(String[] arr) {
		for (String s : arr) {// for each 문을 통해 배열의 각 인덱스 값을 순차적으로 출력 구현
			System.out.print(s + ", ");
		}
		System.out.println();
	}

	static void swap(String[] arr, int ind1, int ind2) {// 앞의 인덱스와 뒤의 인덱스 값 치환 구현
		String s = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = s;
	}

	static void sortData(String[] arr) {// 객체 비교를 위해 arr[i].compareTo() 사용
//		List<String> L = new ArrayList<>();// 배열을 List로 변환하여 Collections.sort() 후 다시 List의 값을 배열에 입력하여 정렬
//		for (int i = 0; i < arr.length; i++) {
//			L.add(arr[i]);
//		}
//		Collections.sort(L);
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = L.get(i);
//		}

		for (int i = 0; i < arr.length - 1; i++) {// String.compareTo() 조건을 이용해서 양수일 경우(오름차순)의 정렬을 버블소팅을 이용해 구현
			for (int j = 0; j < arr.length - i - 1; j++) {// 외부 반복문은 최악의 경우의 수인 전체길이 -1 반복, 내부 반복문은 한 세트 반복 후 마지막 인덱스에 가장 큰 값이 들어가기 때문에 최적화를 위해 반복조건 -i 추가
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					swap(arr, j, j + 1);// 파라미터 배열에서 앞 인덱스와 뒤 인덱스 값의 치환
				}
			}
		}
	}
}
