package mission;

import java.io.BufferedReader;
import java.io.FileReader;

public class SelectionSort1 {
//	private int[] initializeArray() {//중복없이 랜덤값 10개 받기
//		Random rd = new Random();
//		int[] arr = new int[10];
//		int i, j;
//		
//		for (i = 0; i < arr.length; ) {
//			int r = rd.nextInt(1, 101);// 1 ~ 100
////			rd.nextInt(100);// 0 ~ 99
//			for (j = 0; j < i; j++) {
//				if (arr[j] == r) break;
//			}
//			if (j == i) arr[i++] = r;//(j == i)는 루프를 다 돌았을 때를 의미 / for문 break;로 나왔을 때 입력을 방지하기 위함
//		}
//		
//		return arr;
//		
//	}
	
//	private int[] initializeArray1() {
//		Random rd = new Random();
//		List<Integer> list = new ArrayList<>();
//		
//		while(list.size() < 10) {
//			int r = rd.nextInt(1, 101);// 1 ~ 100
//			if(!list.contains(r)) list.add(r);
//		}
//		int[] arr = new int[10];
//		for (int i = 0; i < list.size(); i++)
//			arr[i] = list.get(i);
//		
//		return arr;
//		
//	}
	
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
		
		try (BufferedReader br = new BufferedReader(new FileReader("sortinput.txt"))) {
			String s = br.readLine();
			System.out.println(s);
			int[] arr = new int[10];
			
			for (int[] i : s) {
				arr = i;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SelectionSort ss = new SelectionSort();
			
//		int[] arr = ss.initializeArray();
//		int[] arr = ss.initializeArray1();
//		arr = ss.sort(arr);
//		ss.printArray(arr);
		
	}
}
