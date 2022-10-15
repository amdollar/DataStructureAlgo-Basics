package com.java.SlidingWindow;

public class MaximumPointsFromCards {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		int res = solve(arr, k);
		System.out.println(res);

	}

	private static int solve(int[] arr, int k) {
		int res = 0;
		int left = 0;
		int right = arr.length - k;
		int totalsum = 0;
		for (int i = right; i < arr.length; i++) {
			totalsum += arr[i];
		}
		res = totalsum;
		while (right < arr.length) {
			totalsum += (arr[left] - arr[right]);
			res = Math.max(res, totalsum);
			left++;
			right++;
		}
		return res;
	}

}
