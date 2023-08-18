package com.ruby.java.ch12;

import java.io.FileWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.Properties;

public class Test09 {
	public static void main(String[] args) {
		try(Writer writer = new FileWriter("car.properties")) {
			Properties car = new Properties();
			car.setProperty("model", "X5");
			car.setProperty("engine", "2000");
			car.setProperty("fuel", "3.3");
			
			car.store(writer, "car information");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
