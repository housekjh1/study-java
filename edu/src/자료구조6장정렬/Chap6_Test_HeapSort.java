package 자료구조6장정렬;

import java.util.Random;
import java.util.Scanner;

interface MinHeap {
	public void Insert(int x);

	public int DeleteMin();
}

class Heap implements MinHeap {
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
		if (n >= MaxSize) {
			HeapFull();
			return;
		}
		n++;// 힙 크기 증가
		for (i = n;;) {
			if (i == 1)
				break; // at root
			if (x >= heap[i / 2])
				break; // 부모보다 입력값이 크면 마지막 노드 대입
			// 마지막 노드의 부모보다 입력값이 작은 경우
			heap[i] = heap[i / 2];// 부모를 자식으로 이동
			i /= 2;// 커서를 부모로 이동
		}
		heap[i] = x;
	}

	@Override
	public int DeleteMin() {
		int i, j;
		if (n <= 0) {
			HeapEmpty();
			return 0;
		}
		int x = heap[1];// 루트 값
		int k = heap[n];// 마지막 노드 값
		n--;// 힙 크기 감소
		
		for (i = 1, j = 2; j <= n;) {
			if (j < n && heap[j] > heap[j+1])// 작은 자식노드 쪽으로 커서링
				j++;
			if (k <= heap[j]) break;// 마지막 노드는 루트에 있는 상황에서 그 아래 가장 작은 자식노드와 비교해서 가장 작으면 브레이크
			heap[i] = heap[j];// 가장 작은값 루트로 넘기기
			i = j;// 커서를 자식노드로 옮기기
			j *= 2;// i의 자식노드로 이동
		}
		heap[i] = k;
		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class Chap6_Test_HeapSort {
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
				System.out.println("[heap]");
				heap.display();
				System.out.println("[sorted]");
				showData(sorted);
				break;
			case 3:
				int i = 0;
				while (heap.getN() != 0) {
					sorted[i] = heap.DeleteMin();
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