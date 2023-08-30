package 자료구조2장기본자료구조;

//메소드에 배열 전달 실습부터
//실습 설명한다 
//페이지 52: 메소드 매개변수로 배열 전달
import java.util.Random;

public class 실습2_5메소드배열전달 {
	public static void main(String[] args) {
		int[] data = new int[10];// new 생성자 -> heap에 공간 할당, stack 변수 data, heap에 10개의 정수공간 할당(data는 시작점을 가리킴 ->
									// 참조변수), main 종료 시 data 변수 Pop
		inputData(data);
		for (int num : data) {
			System.out.print(num + " ");
		}
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		int k = 3;
		boolean existValue = findValue(data, k);
		System.out.println("찾는 값 = " + k + " 존재여부 = " + existValue);
	}

	public static void inputData(int[] d) {// 로컬변수 d = data;, 메서드 종료 후 d는 stack에서 사라짐
		Random rand = new Random();// 메서드가 종료되면 로컬변수 rand는 Pop되어 사라짐
		for (int i = 0; i < d.length; i++) {
			d[i] = rand.nextInt(10);// 교재 56 난수의 생성::보충수업 2-3
		}
	}

	static int findMax(int[] items) {// 로컬변수 items stack에 생성 후 메서드 종료 시 items 사라짐
		int max = 0;
		for (int item : items) {
			if (max < item)
				max = item;
		}
		return max;
	}

	static boolean findValue(int[] items, int value) {
		// items[]에 value 값이 있는지를 찾는 알고리즘 구현
		for (int i = 0; i < items.length; i++) {
			if (items[i] == value) return true;
		}
		return false;
	}

}
