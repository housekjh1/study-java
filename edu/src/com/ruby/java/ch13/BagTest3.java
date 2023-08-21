package com.ruby.java.ch13;

class Bag3<T extends Solid> {
	private T thing;
	
	public Bag3(T thing) {
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Solid {}
class Liquid {}

class Book3 extends Solid {}
class PencilCase3 extends Solid {}
class NoteBook3 extends Solid {}

class Water3 extends Liquid {}
class Coffee3 extends Liquid {}

public class BagTest3 {
	public static void main(String[] args) {
		
		Bag3<Book3> bag = new Bag3<>(new Book3());
		Bag3<PencilCase3> bag2 = new Bag3<>(new PencilCase3());
		Bag3<NoteBook3> bag3 = new Bag3<>(new NoteBook3());
		
//		Bag3<Water3> bag4 = new Bag3<>(new Water3());
//		Bag3<Coffee3> bag5 = new Bag3<>(new Coffee3());
	}
}
