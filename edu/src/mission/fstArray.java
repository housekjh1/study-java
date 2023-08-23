package mission;

import java.util.Random;

public class fstArray {
	private static int[] func(int[] a, int[] b) {

		int[] result = new int[a.length];
		int sum = 0;
		int k = 0;
		for (int i = 0; i < 3;) {
			sum = 0;
			for (int j = 0; j < b.length;) {
				sum += a[i++] * b[j += 3];
			}
			result[k++] = sum;
		}
		return result;
	}

	private static void print(int[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Random rd = new Random();
		int[] a = new int[12];
		int[] b = new int[12];

		for (int i = 0; i < a.length; i++) {
			a[i] = rd.nextInt(1, 10);
		}

		for (int i = 0; i < b.length; i++) {
			b[i] = rd.nextInt(1, 10);
		}

		print(a);
		System.out.println("=".repeat(10));
		print(b);
		System.out.println("=".repeat(10));
		print(func(a, b));

	}
}
