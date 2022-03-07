package com.java.DynamicProgramming;

public class SubSetsumDP {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 7 };
		int sum = 11;
		boolean exists = subSetSum(array, sum, array.length);
//		exists = isSubsetSum(array, array.length, sum);
		System.out.println(exists);
	}

	private static boolean subSetSum(int[] array, int sum, int length) {
		// creating the dp array.
		boolean[][] dp = new boolean[length + 1][sum + 1];

		// initialization of array if length of array is 0 (sum can not be find if array
		// length is 0).
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = false;
		}
		// initialization of array if sum is 0. (empty subset can be found in case of
		// sum = 0 also).
		for (int i = 0; i <= length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (array[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - array[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[length][sum];
	}
}
