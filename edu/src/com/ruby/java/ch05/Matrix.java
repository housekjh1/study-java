package com.ruby.java.ch05;

import java.util.Random;

public class Matrix {
	
	static void addMatrix(int[][] a, int[][] b) {
		
		//C = A + B
		int[][] c = new int[3][4];
		//코드 작성
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		showMatrix(c);
	}
	
	static void multiplyMatrix(int[][] a, int[][] d) {
		
		//E = A x D
		int[][] e = new int[3][5];
		int sumAD = 0;
		//코드 작성
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				sumAD = 0;
				for (int k = 0; k < a[0].length; k++) {
					
					sumAD += (a[i][k] * d[k][j]);
				}
				e[i][j] = sumAD;
			}
		}
		
		showMatrix(e);
		
	}
	
	static void showMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.println(a[i][j] + " ");				
			}
		}
	}
	
	public static void main(String[] args) {
		
		Random random = new Random(); //랜덤 객체 생성
		
		int[][] a = new int[3][4];
		int[][] b = new int[3][4];
		int[][] d = new int[4][5];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				
				a[i][j] = random.nextInt(20);
				b[i][j] = random.nextInt(20);
				
								
				
			}
		}
		addMatrix(a, b);
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				
				d[i][j] = random.nextInt(20);
				
				
								
				
			}
		}
		multiplyMatrix(a, d);
		
		/*for (int k = 0; k < d.length; k++) {
			for (int j = 0; j < d[0].length; j++) {
				
				d[i][j] = random.nextInt(20);
				
				multiplyMatrix(a, d);
			}
		}*/
		
		/*int[][] matrixA = {{1,2,3},{4,5,6}};
		int[][] matrixB = {{1,2,3,7,8,9},{4,5,6,10,11,12}};
		
		//System.out.println(matrixA[0].length);
		
		int sumA = 0;
		sumA = makeSum(matrixA);
		
		int sumB = 0;
		sumB = makeSum(matrixA, matrixB);
		
		System.out.println("sumA = " + sumA);
		System.out.println("sumB = " + sumB);
		
	}
	
	static int makeSum(int[][] A) {
		int sumA = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				
				sumA += A[i][j];
				
			}
			
			
		}
		
		return sumA;
		
	}
	
	static int makeSum(int[][] A, int[][] B) {
		int sumB = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				
				sumB += B[i][j];
				
			}
			
			
		}
		
		return sumB;*/
		
	}
	
	
}
