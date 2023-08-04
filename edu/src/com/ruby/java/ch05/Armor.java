package com.ruby.java.ch05;

public class Armor {
	
	void test(String name, int... v) {
		System.out.println(v.length);
	}
	
	public void speedUp(double value) {
		test("hong", 10);
		test("kim", 1,2,3,4,5);
		double speed = value;
	}
	
	public void speedUp(int value, int maxValue) {
		int speed = value;
		int maxSpeed = maxValue;
	}
	
	void takeOff() {
		speedUp(10);
		speedUp(10, 20);
		System.out.println("이륙");
	}
	int land() {
		return 10;
	}
	void shootLaser() {}
	void launchMissile() {}
	
	public static void main(String[] args) {
		//System.out.println("이륙" + age);
	}	
		
		


}
