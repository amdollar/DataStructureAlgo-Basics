package com.java.SlidingWindow;

public class MaxSumOfKEle {
// for given array find out the max sum of k consecutive elements.
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 5, 1, 8, 2, 9, 1 };
		int ans = findSum(arr, 3);
		System.out.println(ans);
	}

	private static int findSum(int[] arr, int k) {
		// [100,200,300,400]
		int i = 0;
		int j = 0;
		int arrlen = arr.length;
		int maxsum = 0;
		int sum = 0;
		while (j < arrlen) {
			// till window is achieved:
			sum += arr[j];
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// do calculation;
				maxsum = Math.max(sum, maxsum);
				// expand window;
				j++;
				sum = sum - arr[i];
				i++;
			}
		}
		return maxsum;
	}

}
