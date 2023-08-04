package com.ruby.java.test1;

import com.ruby.java.test1.*;
import java.util.List;
import java.io.*;

public class Armor {
	
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	
	public void setHeight(int value) {
		height = value;
		weight = takeOff();
	}
	int takeOff() {
		System.out.println("엔진을 구동하다");
		System.out.println("속도를 높이다");
		System.out.println("비행하다");
		return 10;
		//System.out.println("재비행하다");
	}
	
	



}
