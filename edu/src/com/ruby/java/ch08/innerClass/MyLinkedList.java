package com.ruby.java.ch08.innerClass;

class Node {//외부 클래스
	String data;
	Node link;
	
	public Node(String data) {
		this.data = data;
	}
}

public class MyLinkedList {
	
	private Node head = null;
	
//	private class Node {//내부 클래스
//		private String data;
//		private Node link;
//		
//		public Node(String data) {//ex) data: Python, link:
//			this.data = data;
//		}
//	}
	
	public MyLinkedList() {
		
	}
	
	public void add(String data) {//자료구조 공부의 핵심
		Node nd = new Node(data);//new -> 공간할당, 새로운 노드를 만들기, Stack:nd -> Heap: data / link, 참조변수 주솟값 가지고 있음
		Node next = head;//Stack에 next변수 선언
		if (head == null) {
			head = nd;
		} else {
			while (next.link != null) {
				next = next.link;
			}
			next.link = nd;
		}//여기까지 책안보고 쓸 정도로 확실히 이해하기!
		
//		Node newNode = new Node(data);//책내용
//		if(head == null) {
//			head = newNode;
//		} else {
//			Node next = head;
//			while(next.link != null) {
//				next = next.link;
//			}
//			next.link = newNode;
//		}
	}
	
	public void print() {
		Node next = head;
		while (next != null) {
			System.out.println(" " + next.data);
			next = next.link;
		}
	}
}
