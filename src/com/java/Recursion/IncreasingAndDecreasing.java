package com.java.Recursion;

public class IncreasingAndDecreasing {

	public static void main(String[] args) {
		int num = 10;
		printDecreasing(num);
		printIncreasing(num);
	}

	private static void printIncreasing(int num) {
		// identify the base case
		if (num == 0) {
			return;
		}
		printIncreasing(num - 1);
		System.out.println(num);
	}

	private static void printDecreasing(int num) {
		// base case where to stop the calls.
		if (num == 0) {
			return;
		}
		System.out.println(num);
		printDecreasing(num - 1);
	}

}
