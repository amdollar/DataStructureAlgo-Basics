package com.java.SlidingWindow;

public class Solution {

	public static void main(String[] args) {
		int[] arr = new int[] { -1 };
		int k = 1;
		double ans = findMaxAverage(arr, k);
		System.out.println(ans);
	}

	public static double findMaxAverage(int[] arr, int k) {

		int i = 0;
		int j = 0;
		double ans = 0;
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
				if(temp < 0) {
					ans = Math.min(temp, ans);
				}else {
					ans = Math.max(temp, ans);					
				}
				j++;
				sum -= arr[i];
				i++;
				// slide the window
			}
		}
		return ans;
	}
}
