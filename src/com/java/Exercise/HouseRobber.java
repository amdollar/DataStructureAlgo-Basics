package com.java.Exercise;

public class HouseRobber {
	public static void main(String[] args) {
		int houses[] = new int[] { 5, 3, 4, 11, 2 };
		int maxRob = maximumRob(houses);
		System.out.println(maxRob);
	}

	private static int maximumRob(int[] houses) {
		if (houses == null || houses.length == 0) {
			return 0;
		}
		if (houses.length == 1) {
			return houses[0];
		}
		if (houses.length == 2) {
			return Math.max(houses[0], houses[1]);
		}

		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[1], houses[0]);

		for (int i = 2; i < houses.length; i++) {
			dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
		}

		return dp[houses.length - 1];
	}
}
