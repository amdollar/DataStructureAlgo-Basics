package com.java.DynamicProgramming;

public class Knapsack01DP {
	static int dp[][] = new int[1000][1000];
	static {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
	}

	public static void main(String[] args) {
		int[] weights = new int[] { 10, 20, 30 };
		int[] price = new int[] { 60, 100, 120 };
		int capacity = 50;
		int maxValue = knapsack(weights, price, capacity, weights.length);
		System.out.println(maxValue);
	}

	private static int knapsack(int[] weights, int[] price, int capacity, int len) {
		// convert base condition to the initialization of dp array;
		// initialization of 0th row and col with the base case return value :
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		// dp array would be filled till the range of price and capacity of given
		// problem
		for (int i = 1; i < len + 1; i++) {
			for (int j = 1; j < capacity + 1; j++) {
				if (weights[i - 1] <= j) {
					// simply replace len -> i and c-> j will work here.
					dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[len][capacity];

	}
}
