package 자료구조4장스택큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Point1 {
	private int ix;
	private int iy;

	public Point1(int ix, int iy) {
		super();
		this.ix = ix;
		this.iy = iy;
	}

	public int getIx1() {
		return ix;
	}

	public void setIx1(int ix) {
		this.ix = ix;
	}

	public int getIy1() {
		return iy;
	}

	public void setIy1(int iy) {
		this.iy = iy;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point1) p).ix) && (this.iy == ((Point1) p).iy)) {
			return true;
		} else
			return false;
	}
}

class objectQueue1 {
	private List<Point1> list;
	private int capacity, rear, front, num;
	
	public class OverflowQueueException1 extends RuntimeException {
		public OverflowQueueException1() {}
	}
	
	public class EmptyQueueException1 extends RuntimeException {
		public EmptyQueueException1() {}
	}
	
	public objectQueue1(int maxlen) {
		capacity = maxlen;
		rear = front = num = 0;
		try {
			list = new ArrayList<Point1>(capacity);
		} catch (OutOfMemoryError e) {
			System.out.println(e.getMessage());
			capacity = 0;
		}
	}
	
	public Point1 enque1(Point1 x) throws OverflowQueueException1 {
		if (num >= capacity) throw new OverflowQueueException1();
		list.add(x);
		num++;
		rear++;
		return x;
	}
	
	public Point1 deque1() throws EmptyQueueException1 {
		if (num <= 0) throw new EmptyQueueException1();
		Point1 x = list.get(front);
		list.remove(front);
		num--;
		rear--;
		return x;
	}
	
	public Point1 peek1() throws EmptyQueueException1 {
		if (num <= 0) throw new EmptyQueueException1();
		return list.get(front);
	}
	
	public void clear1() {
		rear = front = num = 0;
	}
	
	public int indexOf1(Point1 x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (list.get(idx).equals(x)) return idx;
		}
		return -1;
	}
	
	public int getCapacity1() {
		return capacity;
	}
	
	public int size1() {
		return num;
	}
	
	public boolean isEmpty1() {
		return num <= 0;
	}
	
	public boolean isFull1() {
		return num >= capacity;
	}
	
	public void dump1() {
		if (num <= 0) System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				int idx = (i+front) % capacity;
				System.out.print(list.get(idx) + " ");
			}
			System.out.println();
		}
	}
}

public class Ex_객체큐_리스트 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue1 s = new objectQueue1(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point1 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size1(), s.getCapacity1());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point1(rndx, rndy);
				try {
					s.enque1(p);
				} catch (objectQueue1.OverflowQueueException1 e) {
					System.out.println("큐가 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque1();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (objectQueue1.EmptyQueueException1 e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek1();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (objectQueue1.EmptyQueueException1 e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump1();
				break;
			}
		}
	}
}
