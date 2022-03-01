package com.java.DynamicProgramming;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 5, 7, 10 };
		int m = 16;
		System.out.println(findMaxWays(coins, m));
	}

	private static int findMaxWays(int[] coins, int m) {

		int[] dp = new int[m + 1];
		dp[0] = 0;
		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int c : coins) {
				if (i - c >= 0) {
					dp[i] = Math.min(dp[i], dp[i - c] + 1);
				}
			}
		}

		return dp[m];
	}

}
