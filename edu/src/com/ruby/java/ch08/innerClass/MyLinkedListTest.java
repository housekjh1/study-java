package com.ruby.java.ch08.innerClass;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
//		myList.head
		myList.add("11");
		myList.add("55");
		myList.add("77");
		myList.add("177");
		myList.add("33");
		myList.print();
		myList.delete("177");
		System.out.println("삭제후 출력: ");
		myList.print();
		//MyLinkedList.Node nd = myList.new Node("Hong");//not visible
		//nd.data = "hello";
	}
}
