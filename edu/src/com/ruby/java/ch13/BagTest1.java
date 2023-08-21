package com.ruby.java.ch13;

class Bag1 {
	private Object thing;
	
	public Bag1(Object thing) {
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book1 {}
class PencilCase1 {}
class NoteBook1 {}

public class BagTest1 {
	public static void main(String[] args) {
		
		Bag1 bag = new Bag1(new Book1());
		Bag1 bag2 = new Bag1(new PencilCase1());
		Bag1 bag3 = new Bag1(new NoteBook1());
		
		Book1 book = (Book1) bag.getThing();
		PencilCase1 pc = (PencilCase1) bag2.getThing();
		NoteBook1 nb = (NoteBook1) bag3.getThing();
		
		bag = bag2;
	}
}
