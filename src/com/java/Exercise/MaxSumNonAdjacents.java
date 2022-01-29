package com.java.Exercise;

public class MaxSumNonAdjacents {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 5, 10, 100, 10, 205 };
		int res = findMaxSum(arr);
		System.out.println(res);
	}

	private static int findMaxSum(int[] arr) {
		int maxsum = 0;
		int tempsum1 = 0;
		int tempsum2 = 0;
		for (int i = 0; i <= arr.length - 2; i = i + 2) {
			tempsum1 += arr[i];
		}

		for (int i = 1; i <= arr.length - 1; i = i + 2) {
			tempsum2 += arr[i];
		}
		maxsum = Math.max(tempsum1, tempsum2);

		return maxsum;
	}

}
