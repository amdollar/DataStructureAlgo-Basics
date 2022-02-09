package com.java.Recursion;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 5;
		int nthNumInFib = findNthFib(n);
		System.out.println(nthNumInFib);
	}

	private static int findNthFib(int n) {

		// base case and its results
		if (n == 1 | n == 0) {
			return n;
		}
		int fin1 = findNthFib(n - 1);
		int fin2 = findNthFib(n - 2);

		return fin1 + fin2;
	}

}
