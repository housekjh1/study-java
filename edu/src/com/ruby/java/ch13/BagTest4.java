package com.ruby.java.ch13;

class Bag4<T extends Solid4> {
	private T thing;
	private String owner;
	
	public Bag4(T thing) {
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
//	boolean isSameOwner(Bag<T> obj) {
//		if (this.owner.equals(obj.getOwner())) {
//			return true;
//		}
//		return false;
//	}
}
class Solid4 {}
class Liquid4 {}

class Book4 extends Solid4 {}
class PencilCase4 extends Solid4 {}
class NoteBook4 extends Solid4 {}

class Water4 extends Liquid4 {}
class Coffee4 extends Liquid4 {}

public class BagTest4 {
	public static void main(String[] args) {
		
		Bag4<Book4> bag = new Bag4<>(new Book4());
		Bag4<PencilCase4> bag2 = new Bag4<>(new PencilCase4());
		Bag4<NoteBook4> bag3 = new Bag4<>(new NoteBook4());
		
//		Bag4<Water4> bag4 = new Bag4<>(new Water4());
//		Bag4<Coffee4> bag5 = new Bag4<>(new Coffee4());
	}
}
