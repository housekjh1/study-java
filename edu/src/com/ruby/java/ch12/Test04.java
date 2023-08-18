package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class Test04 {
	public static void main(String[] args) {
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
			ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			byte[] arr = out.toByteArray();
//			String s = new String(arr);
//			System.out.println(s);
			System.out.println(new String(arr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
