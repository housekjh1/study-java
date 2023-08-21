package com.ruby.java.ch13;

class Bag2<T, N> {
	private T thing;
	private N name;
	
	public Bag2(T thing, N name) {
		this.thing = thing;
		this.name = name;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public N getName() {
		return name;
	}

	public void setName(N name) {
		this.name = name;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
		System.out.println("N의 타입은 " + name.getClass().getName());
	}
}

class Book2 {
	public String toString() {
		return "책";
	}
}

class PencilCase2 {}
class NoteBook2 {}

public class BagTest2 {
	public static void main(String[] args) {
		
		Bag2<Book2, String> bag = new Bag2<Book2, String>(new Book2(), "과학");
		
		bag.showType();
		
		Book2 book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is: " + book);
		System.out.println("Name is: " + name);
	}
}
