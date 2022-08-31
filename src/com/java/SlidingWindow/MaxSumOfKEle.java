package com.java.SlidingWindow;

public class MaxSumOfKEle {
// for given array find out the max sum of k consecutive elements.
	public static void main(String[] args) {
		int arr[] = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int ans = findSum(arr, 4);
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
