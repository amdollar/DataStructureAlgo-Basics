package com.java.RecursionChapter2;

public class Print1toN {

	public static void main(String[] args) {
		int n = 10;

		print(n);

	}

	private static void print(int i) {

		// BC: smallest valid input = 1;
		if (i == 0) {
			return;
		}
		// Hypothesis: run on smaller input:
		print(i - 1);
		// Induction:
		System.out.println(i);
	}
}
