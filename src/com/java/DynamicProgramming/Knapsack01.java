package com.java.DynamicProgramming;

public class Knapsack01 {
	// this array would be initialized for the purpose of memorization of variables
	// which are changing frequently throughout the recursion call
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
		int maxValue = knapsack(weights, price, capacity, weights.length - 1);
		System.out.println(maxValue);
	}

	private static int knapsack(int[] weights, int[] price, int capacity, int len) {
		// base condition for recursion: min possible valid input
		if (capacity == 0 || len == 0)
			return 0;

		// this array will return the value if already calculated.
		if (dp[capacity][len] != -1) {
			return dp[capacity][len];
		}
		// if we want to include the item in the bag or not: based on:
		// if item weight is < capacity and if I want to include(if it gives me max
		// profit)
		// and if the weight> capacity then discard this item from the input arr
		if (capacity >= weights[len]) {
			return dp[capacity][len] = Math.max(price[len] + knapsack(weights, price, capacity - weights[len], len - 1),
					knapsack(weights, price, capacity, len - 1));
		} else {
			return dp[capacity][len] = knapsack(weights, price, capacity, len - 1);
		} // (capacity < weights[len])
	}
}
