package mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort2 {
	
	private void printArray2(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n" + "=".repeat(29));
	}
	
	private int[] sort2(int[] arr) {
		
		for (int len = arr.length; 1 < len; len--) {
//			int k2 = 0;
			
			for (int i = 1; i < len; i++) {
				if (arr[i-1] > arr[i]) {
					int t = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = t;
				} else {
					continue;
				}
			}
			
//			for (int i = 1; i < len; i++) {
//				if (arr[k2] > arr[i]) {
//					continue;
//				} else {
//					k2 = i;
//				}
//			}
			
//			int t2 = arr[len-1];
//			arr[len-1] = arr[k2];
//			arr[k2] = t2;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("sortinput.txt"))) {
			String line;
			
			while ((line = br.readLine()) != null) {
				int num = Integer.parseInt(line);
				numbers.add(num);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] arr = new int[numbers.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = numbers.get(i);
		}
		
		
		SelectionSort2 ss = new SelectionSort2();
		
//		int[] arr = ss.initializeArray();
//		int[] arr = ss.initializeArray1();
		arr = ss.sort2(arr);
		ss.printArray2(arr);
		
	}
}