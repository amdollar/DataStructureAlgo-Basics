package com.java.SlidingWindow;

public class MaxAvgSubarray {

	public static void main(String[] args) {
		int arr[] = new int[] { -1 };
		int k = 1;
		double res = findMaxAverage(arr, k);
		System.out.println(res);
	}

	private static double findMaxAverage(int[] arr, int k) {
		int i = 0;
		int j = 0;
		double ans = Integer.MIN_VALUE;
		double sum = 0;
		while (j < arr.length) {
			// calculation
			sum += arr[j];
			// reach the size
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// answer calculation
				double temp = sum / k;
				ans = Math.max(temp, ans);
				j++;
				sum -= arr[i];
				i++;
				// slide the window
			}
		}
		return ans;
	}

//	public static double findMaxAverage(int[] nums, int k) {
//		double max_average = -2147483647;
//		double sum = 0;
//		int i = 0;
//		int j = 0;
//
//		sum = sum + nums[j];
//
//		while (j < nums.length && i <= nums.length - k) {
//
//			if (j - i + 1 == k) {
//				double temp = sum / k;
//				max_average = Math.max(max_average, temp);
//				sum = sum - nums[i];
//				i++;
//			} else if (j - i + 1 < k) {
//				j++;
//				sum = sum + nums[j];
//			}
//
//		}
//		return max_average;
//	}

}
