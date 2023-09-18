package 자료구조6장정렬;

//단순 삽입 정렬 - 6.4

import java.util.Scanner;

class 실습6_5InsertionSort {
//--- 단순 삽입 정렬 ---//
	static void insertionSort(int[] a, int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			int j = i;
			int tmp = a[i];
			while (j > 0 && a[j - 1] > tmp) {
				a[j] = a[j - 1];
				j--;
				count++;
			}
			a[j] = tmp;
		}
		
		System.out.println("비교횟수 = " + count);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
//		int nx = 7;
//		int[] x = { 6, 4, 1, 7, 3, 9, 8 };
		for (int i = 0; i < nx; i++) {
			double d = Math.random();
			x[i] = (int) (d * 100);
		}
		for (int n : x)
			System.out.print(" " + n);
		System.out.println();

		insertionSort(x, nx); // 배열 x를 단순삽입정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print("  " + x[i]);
	}
}
