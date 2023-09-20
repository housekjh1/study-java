package 자료구조6장정렬.ex;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort_Ex01 {
	static int count;

	public static void heapSort(int[] arr) {
		int n = arr.length;

		// Step 1: 초기 힙 구성
		// 배열의 중간부터 시작하여 최대 힙 속성을 갖추도록 함
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, i, n);
		}
		System.out.print("초기 힙 구성 : [");
		for (int item : arr) {
		System.out.print(item + ", ");
		}
		System.out.println("]");
		// Step 2: 최대 힙을 이용하여 정렬 수행
		for (int i = n - 1; i > 0; i--) {
			// 최대 힙의 루트 요소와 현재 요소를 교환
			swap(arr, 0, i);

			// 힙 크기를 줄이고, 다시 최대 힙 속성을 유지
			maxHeapify(arr, 0, i);
		}
	}

	private static void maxHeapify(int[] arr, int i, int heapSize) {
		int largest = i;

		while (true) {
			int leftChildIdx = 2 * i + 1;
			int rightChildIdx = 2 * i + 2;

			// 왼쪽 자식이 루트보다 크면 largest를 왼쪽 자식으로 설정
			if (leftChildIdx < heapSize && arr[leftChildIdx] > arr[largest]) {
				largest = leftChildIdx;
			}

			// 오른쪽 자식이 루트보다 크면 largest를 오른쪽 자식으로 설정
			if (rightChildIdx < heapSize && arr[rightChildIdx] > arr[largest]) {
				largest = rightChildIdx;
			}

			// largest가 루트가 아니라면 교환
			if (largest != i) {
				swap(arr, i, largest);
				count++;
				i = largest; // i를 largest로 업데이트하여 다음 레벨로 이동
			} else {
				break; // 최대 힙 속성이 복원되었으므로 종료
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("요솟수 : ");
		int m = sc.nextInt();
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = rd.nextInt(99) + 1;
		}
		System.out.println("정렬 전 배열: " + Arrays.toString(arr));
		count = 0;
		heapSort(arr);
		System.out.println("정렬 후 배열: " + Arrays.toString(arr));
		System.out.println("count : " + count);
	}
}
