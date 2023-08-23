package mission;

import java.util.Random;

public class sndArray {

	private static int[][] func(int[][] a, int[][] b) {

		int[][] result = new int[a.length][b[0].length];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				sum = 0;
				for (int k = 0; k < b.length; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum;
			}

		}

		return result;
	}

	private static void print(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Random rd = new Random();
		int[][] a = new int[3][4];
		int[][] b = new int[4][3];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = rd.nextInt(1, 10);
			}
		}
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = rd.nextInt(1, 10);
			}
		}
		
		print(a);
		System.out.println("=".repeat(10));
		print(b);
		System.out.println("=".repeat(10));
		print(func(a, b));

	}
}
