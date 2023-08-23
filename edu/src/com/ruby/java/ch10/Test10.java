package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {
	public static void main(String[] args) {

		lotto_gen(5);

	}

	public static void lotto_gen(int n) {
		Random rd = new Random();
		HashSet<Integer> lotto = null;
		for (int i = 0; i < n; i++) {
			lotto = new HashSet<Integer>();

			for (int j = 0; lotto.size() <= 6; j++) {
//				int a = 0;
//				while(n == 0) {
//					a = rd.nextInt(46);
//				}
//				lotto.add(a);
				lotto.add(rd.nextInt(45) + 1);
			}

			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L);
		}
	}
}
