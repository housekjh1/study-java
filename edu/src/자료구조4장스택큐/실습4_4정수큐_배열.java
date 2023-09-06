package 자료구조4장스택큐;

/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;

//int형 고정 길이 큐

class IntQueue2 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue2Exception extends RuntimeException {
		public EmptyIntQueue2Exception() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue2Exception extends RuntimeException {
		public OverflowIntQueue2Exception() {
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue2(int maxlen) {
		//구현
		front = rear = num = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntQueue2Exception {
		//구현
		if (num >= capacity) throw new OverflowIntQueue2Exception();
		int r = que[rear++] = x;
		num++;
		if (rear >= capacity) rear = 0;
		return r;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue2Exception {
		//구현
		if (num <= 0) throw new EmptyIntQueue2Exception();
		int r = que[front++];
		num--;
		if (front >= capacity) front = 0;
		return r;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue2Exception {
		//구현
		if (num <= 0) throw new EmptyIntQueue2Exception();
		return que[front];
	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		//구현
		for (int i = 0; i <= num; i++) {
			int idx = (i + num) % capacity;
			if (que[idx] == x) return idx; 
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
		//구현
		if (num == 0) System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				int idx = (i + front) % capacity;
				System.out.print(que[idx] + " ");
			}
			System.out.println();
		}
	}
}

public class 실습4_4정수큐_배열 {

//int형 고정 길이 큐의 사용 예

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue2 s = new IntQueue2(4); // 최대 64개를 인큐할 수 있는 큐

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
				} catch (IntQueue2.OverflowIntQueue2Exception e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (IntQueue2.EmptyIntQueue2Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntQueue2.EmptyIntQueue2Exception e) {
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
