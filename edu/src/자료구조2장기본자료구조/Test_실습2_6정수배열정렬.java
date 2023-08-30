package 자료구조2장기본자료구조;

import java.util.Random;

public class Test_실습2_6정수배열정렬 {
	public class 실습2_6정수배열정렬 {
		public static void main(String[] args) {
			int[] data = new int[10];
			inputData(data);
			for (int num : data) {
				System.out.print(num + " ");
			}

			sortData(data);
			System.out.println();
			for (int num : data) {
				System.out.print(num + " ");
			}

			reverse(data);// 역순으로 재배치 - 정렬 아님
			System.out.println();
			for (int num : data) {
				System.out.print(num + " ");
			}

			reverseSort(data);// 역순으로 재배치 - 정렬 아님
			System.out.println();
			for (int num : data) {
				System.out.print(num + " ");
			}
		}

		static void inputData(int[] data) {// 랜덤값 입력
			Random rd = new Random();
			for (int i = 0; i < data.length; i++) {
				data[i] = rd.nextInt(10) + 1;
			}
		}

		static void sortData(int[] arr) {
//			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						swap(arr, i, j);
					}
				}
			}
//			List<Integer> L = new ArrayList<>();// 배열을 List 변환 후 Collections.sort() 사용 후 다시 List를 배열로 변환
//			for (int i = 0; i < arr.length; i++) {
//				L.add(arr[i]);
//			}
//			Collections.sort(L);
//			for (int j = 0; j < arr.length; j++) {
//				arr[j] = L.get(j);
//			}
		}

		static void swap(int[] arr, int ind1, int ind2) {
			int t = arr[ind1];
			arr[ind1] = arr[ind2];
			arr[ind2] = t;
		}

		static void reverse(int[] a) {
			for (int i = 0; i < a.length / 2; i++) {
				swap(a, i, a.length - 1 - i);// 처음 인덱스 값과 마지막 인덱스 값의 치환 후 반을 기점으로 데칼코마니
			}
		}

		static void reverseSort(int[] arr) {
			for (int i = 0; i < arr.length / 2; i++) {
				int t = arr[i];
				arr[i] = arr[arr.length - 1 - i];
				arr[arr.length - 1 - i] = t;
			}
//			int len = arr.length;
//			for (int i = 0; i < arr.length / 2; i++) {
//				swap(arr, i, len - 1);
//				len--;
//			}
		}

	}
}
