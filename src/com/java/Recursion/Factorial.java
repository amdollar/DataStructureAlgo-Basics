package com.java.Recursion;

public class Factorial {

	public static void main(String[] args) {
		int num = 5;
		int res = factorial(num);
		System.out.println(res);
	}

	// identification of base case and its result.
	private static int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		int ans = num * factorial(num - 1);
		return ans;
	}

}
