package com.java.DynamicProgramming;

public class Knapsack01 {

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

		// if we want to include the item in the bag or not: based on:
		// if item weight is < capacity and if I want to include(if it gives me max
		// profit)
		// and if the weight> capacity then discard this item from the input arr
		if (capacity >= weights[len]) {
			return Math.max(price[len] + knapsack(weights, price, capacity - weights[len], len - 1),
					knapsack(weights, price, capacity, len - 1));
		} else {
			return knapsack(weights, price, capacity, len - 1);
		} // (capacity < weights[len])
	}
}
