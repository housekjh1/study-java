package package4;

import java.util.Scanner;

public class Test37 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 수 입력 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("값입력 : ");
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999;
		
		for (int j = 0; j < arr.length; j++ ) {
			sum += arr[j];
			if(max < arr[j])
				max = arr[j];
			if(min > arr[j])
				min = arr[j];
		}
		
		avg = (double)sum / arr.length;
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}

}
