package 자료구조6장정렬;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap

	public int getN() {
		return n;
	}

	public Heap(int sz) {
		MaxSize = sz;
		n = 0;
		try {
			heap = new int[MaxSize];
		} catch (Exception e) {
			MaxSize = 0;
		}
	}

	public void display() {
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	@Override
	public void Insert(int x) {
		int i;
		if (n >= MaxSize) { HeapFull(); return; }
		n++;
		for (i = n; ; ) {
			if (i == 1) break; // at root
			if (x <= heap[i / 2]) break;
			// move from parent to i
			heap[i] = heap[i / 2];
			i /= 2;
//			System.out.println("<"+n+">heap["+i+"] : "+heap[i]+", heap["+(i / 2)+"] : "+heap[i / 2]+", x : "+x);
		}
		heap[i] = x;
//		System.out.println("<" + n + ">" + "heap[" + i + "] : " + heap[i]);
	}

	@Override
	public int DeleteMax() {
		int i, j;
		if (n <= 0) { HeapEmpty(); return 0; }
		int x = heap[1]; int k = heap[n]; n--;

		for (i = 1, j = 2; j <= n; )
		{
			if (j < n) if (heap[j] < heap[j + 1]) j++;
			// j points to the larger child
			if (k >= heap[j]) break;
			heap[i] = heap[j];
			i = j; j *= 2;
			System.out.println("i="+i+", j="+j+", k="+k+", heap["+i+"] = "+heap[i]+", heap["+j+"] = "+heap[j]+", heap["+(j+1)+"] = "+heap[j+1]+", heap["+n+"] = "+heap[n]);
		}
		heap[i] = k;
		System.out.println("k="+k+", heap["+i+"]="+heap[i]);
		return x;

	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class Chap6_Test_HeapSort_01 {
	static void showData(int[] d) {
		for (int i = 0; i < d.length; i++)
			System.out.print(d[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 10;
		int[] x = new int[count + 1];
		int[] sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:// 난수 생성
				for (int i = 1; i < count + 1; i++) {
					x[i] = rnd.nextInt(30) + 1;
					heap.Insert(x[i]);
				}
				break;
			case 2:
				System.out.println("[x]");
				showData(x);
				System.out.println("[heap]");
				heap.display();
				System.out.println("[sorted]");
				showData(sorted);
				break;
			case 3:
				int i = 0;
				while (heap.getN() != 0) {
					sorted[i] = heap.DeleteMax();
					System.out.println("sorted["+i+"]="+sorted[i]);
					i++;
				}
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
