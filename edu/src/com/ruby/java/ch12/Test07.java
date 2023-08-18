package com.ruby.java.ch12;

import java.io.File;
import java.io.RandomAccessFile;

public class Test07 {
	public static void main(String[] args) {
		File f = new File("a.txt");
		try(RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
			raf.seek(1);
			byte b = raf.readByte();
			System.out.println((char)b);
			
			byte[] arr = new byte[4];
			raf.read(arr);
			System.out.println(new String(arr));
			
			raf.seek(2);
			raf.write("good".getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
