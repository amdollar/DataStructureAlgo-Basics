package com.java.Recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 23;
		String s = "A";
		String h = "B";
		String t = "C";
		printWays(n, s, t, h);

	}

	private static void printWays(int n, String s, String t, String h) {
		// base condition : when single plate is remaining on the source, move it to
		// target
		if (n == 1) {
			System.out.println("Move " + n + " plate from " + s + " to :" + t);
			return;
		}
		// hypothesis: apply solution for small input:
		// 1. Move n-1 plates to helper
		// 2. Move n-1 plates from helper to target
		printWays(n - 1, s, h, t);
		System.out.println("Move " + n + "plate from " + s + " to :" + t);
		printWays(n - 1, h, t, s);

		// induction

	}

}
