package 자료구조4장스택큐;

import java.util.Scanner;
/*
 * Queue of ArrayList
 */
import java.util.ArrayList;
import java.util.List;

//int형 고정 길이 큐

class Queue2 {
//	private int[] que; // 큐용 배열
	private List<Integer> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//--- 생성자(constructor) ---//
	public Queue2(int maxlen) {
		// 구현
		front = rear = num = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<Integer>(capacity);
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
	    // 구현
		if (num >= capacity) throw new OverflowQueueException();
		que.add(rear, x);
		rear++;
		num++;
		return 1;
	}


//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
	    // 구현
		if (num <= 0) throw new EmptyQueueException();
		int r = que.get(front);
		que.remove(front);
		rear--;
		num--;
		return r;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		// 구현
		if (num <= 0) throw new EmptyQueueException();
		return que.get(front);
	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		// 구현
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que.get(idx) == x) return idx;
		}
		return -1;
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		// 구현
		if (num <= 0) {
	        System.out.println("큐가 비어 있습니다.");
	        return;
	    }
		
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			System.out.print(que.get(idx) + " ");
		}
		System.out.println();
	}
}

public class 실습4_4정수큐_리스트 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue2 s = new Queue2(4); // 최대 64개를 인큐할 수 있는 큐

		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch (Queue2.OverflowQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (Queue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (Queue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
