package com.java.SlidingWindow;

public class MinimumSizeSubArraySum {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 4, 4 };
		int target = 8;
		int res = minSubArrayLen(target, arr);
		System.out.println(res);

	}

// variable size window
	// condition: target == sum
	public static int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int i = 0;
		int winsiz = Integer.MAX_VALUE;
		int maxmin = 0;
		int j = 0;
		while (j < nums.length && i < nums.length) {
			sum += nums[j];
			if (sum < target) {
				j++;
			} else if (sum == target) {
				// ans
				winsiz = Math.min(winsiz, j - i + 1);
				// remove i
				sum -= nums[i];
				// increase window
				i++;
				j++;
			} else if (sum > target) {
				// remove i
				maxmin = Math.min(maxmin, sum);
				winsiz = Math.min(winsiz, j - i + 1);
				sum -= nums[i];
				// increase window
				sum -= nums[j];
				i++;
			}
		}
		return winsiz == Integer.MAX_VALUE ? 0 : winsiz;
	}

}
