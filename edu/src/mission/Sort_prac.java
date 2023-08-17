package mission;

import java.util.Random;

public class Sort_prac {
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(1, 101);
		}
		
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
		
		for (int k = 0; k < arr.length; k++) {
			int maxV = 0;
			int idx = arr.length-1;
			
			if (arr[k] > maxV) {
				maxV = arr[k];
			}
			if(k != 0) {
				if (arr[k-1] > arr[k]) {
					int swap = arr[k-1];
					arr[k-1] = arr[k];
					arr[k] = swap;
				}
			}
//			arr[k] = arr[idx];
//			arr[idx] = maxV;
//			idx -= 1;
			}
		
		
		for (int l : arr) {
			System.out.print(l + " ");
		}
	}
}
