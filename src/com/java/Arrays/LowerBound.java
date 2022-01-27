package com.java.Arrays;

public class LowerBound {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 6 };
		int num = 4;
		int res = findLowerBound(arr, num);
		System.out.println(res);
	}

	// Time complexity: O(n) if array length > 1 | space complexity: 1
	private static int findLowerBound(int[] arr, int num) {
		if (arr[0] > num) {
			return -1;
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > num) {
					return arr[i - 1];
				}
			}
		}
		return 0;
	}

}
