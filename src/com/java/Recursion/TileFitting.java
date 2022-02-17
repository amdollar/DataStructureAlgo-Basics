package com.java.Recursion;

public class TileFitting {

	// tile size = 4 x 1
	public static void main(String[] args) {
		int m = 10;
		int maxways = findMaxWays(4, m);
		System.out.println(maxways);
	}

	private static int findMaxWays(int n, int m) {
		if (m <= 3) {
			return 1;
		}
		int res = findMaxWays(4, m - 1) + findMaxWays(4, m - 4);
		return res;
	}

}
