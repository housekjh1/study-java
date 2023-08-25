package 자료구조2장기본자료구조;

import java.util.Random;

public class Test_실습2_7다차원배열 {
	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] D = new int[2][3];
		inputData(A);
		inputData(B);
		inputData(D);
		System.out.println("A[][]");
		showData(A);
		System.out.println("\nD[][]");
		showData(D);
		System.out.println("\nB[][]");
		showData(B);
		System.out.println("\nE[][]");
		int[][] E = addMatrix(A, D);
		showData(E);
		System.out.println("\nC[][]");
		C = multiplyMatrix(A, B);
		showData(C);
		System.out.println("\nF[][]");
		int[][] F = transposeMatrix(A);
		showData(F);
		boolean result = equals(A, D);
		System.out.println("\nequals(A,D) = " + result);
	}

	static void inputData(int[][] data) {
		Random rd = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = rd.nextInt(10);
			}
		}
	}

	static void showData(int[][] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean equals(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (a[i][j] != b[i][j])
					return false;
			}
		}
		return true;
	}

	static int[][] addMatrix(int[][] X, int[][] Y) {
		int[][] result = new int[X.length][Y[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < Y[0].length; j++) {
				result[i][j] = X[i][j] + Y[i][j];
			}
		}
		return result;
	}

	static int[][] multiplyMatrix(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	static int[][] transposeMatrix(int[][] a) {
		int[][] result = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[j][i] = a[i][j];
			}
		}
		return result;
	}

}
