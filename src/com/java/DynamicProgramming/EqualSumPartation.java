package com.java.DynamicProgramming;

/*
 * This program is to find if there exists two part of the array
 * like sum of these two parts is equal.
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 */
public class EqualSumPartation {

	public static void main(String[] args) {

		int arr[] = new int[] { 5, 11, 20 };
		boolean res = findEqualSumPartation(arr);
		System.out.println(res);
	}

	private static boolean findEqualSumPartation(int[] arr) {
		// find out the sum of all the elements of the array/
		// if sum is even then equal sum partition will exists o/w there is no
		// possibility of that existing.
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum % 2 == 1 ? false : isEqualSum(arr, arr.length, sum / 2);
	}

	private static boolean isEqualSum(int[] arr, int length, int sum) {
		if (length == 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}
		boolean[][] dp = new boolean[length + 1][sum + 1];

		for (int i = 0; i <= sum; i++) {
			dp[0][i] = false;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[length][sum];
	}

}
