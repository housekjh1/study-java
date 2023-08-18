package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {
	public static void main(String[] args) {
		try (FileInputStream my = new FileInputStream("a.txt");) {
			int c = 0;
			while ((c = my.read()) != -1) {
				System.out.print((char)c);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n" + "=".repeat(50) + "\nDone");
	}
}
