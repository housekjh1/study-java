package com.ruby.java.ch08.innerClass;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
//		myList.head
		myList.print();
		myList.add("java");
		myList.add("html");
		myList.add("css");
		myList.print();
	}
}
