package com.ruby.java.ch08.polymorphism;
//polymorphism 실습 예제 코드

abstract class Vehicle {
	String engineType;
	int numberWheels;
	public Vehicle(String engineType, int numberWheels) {
		this.engineType = engineType; this.numberWheels = numberWheels;
	}
	public abstract void displayWheels();
	
}

class Truck extends Vehicle {
	int weight;	
	public Truck(String engineType, int numberWheels, int weight) {
		super(engineType, numberWheels); this.weight = weight;
	}
}

class Car extends Vehicle {
	int vehicleOccupants;
	public Car(String engineType, int numberWheels, int vehicleOccupants) {
		super(engineType, numberWheels); this.vehicleOccupants = vehicleOccupants;
	}
}
class MotorCycle extends Vehicle {
	int price;
	public MotorCycle(String engineType, int numberWheels, int price) {
		super(engineType, numberWheels); this.price = price;
	}
}
public class ch08_test_polymorphism실습 {
	public static void checkWheels(Vehicle[] a) {
		for (Vehicle v : a) {
			v.displayWheels();
		}
	}
	public static void main(String[] args) {
		Vehicle[] arr = new Vehicle[5];
		arr[0] = new Truck("디젤", 4, 1);
		arr[1] = new Car("가솔린", 4, 5);
		arr[2] = new MotorCycle("가솔린", 2, 1000);
		arr[3] = new Truck("가솔린", 4, 2);
		arr[4] = new Car("디젤", 4, 9);
		checkWheels(arr);
	}
}
