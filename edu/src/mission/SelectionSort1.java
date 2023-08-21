package mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort1 {
	
	private void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n" + "=".repeat(29));
	}
	
	private int[] sort(int[] arr) {
		
		for (int len = arr.length; 1 < len; len--) {
		//1. 전체 배열에서 제일 큰 값을 검색
			int k = 0;
			
			for (int i = 1; i < len; i++) {
				if (arr[k] > arr[i]) {
					continue;
				} else {
					k = i;
				}
			}
		//2. 찾은 제일 큰 값과 배열의 마지막 값을 swap
			int t = arr[len-1];
			arr[len-1] = arr[k];
			arr[k] = t;
		}
		//3. 제일 마지막을 제외한 배열에서 제일 큰 값을 검색
		//4. 찾은 제일 큰 값과 배열의 마지막 앞의 값을 swap
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
		
		
		SelectionSort1 ss = new SelectionSort1();
		
//		int[] arr = ss.initializeArray();
//		int[] arr = ss.initializeArray1();
		arr = ss.sort(arr);
		ss.printArray(arr);
		
	}
}