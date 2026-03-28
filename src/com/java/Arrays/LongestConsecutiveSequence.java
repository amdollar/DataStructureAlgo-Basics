package com.java.Arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = new int[] { 100, 101, 102, 3, 2, 103, 104, 1, 4 };
		int ans = findLongestConSeq(arr);
		System.out.println(ans);
	}

// O(nlog n) + O (n) = O (n log n)
	private static int findLongestConSeq(int[] arr) {
		int ans = 0;
		Arrays.sort(arr);
		int prev = arr[0];
		int curr = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == prev + 1) {
				curr++;
			} else if (arr[i] != prev + 1) {
				curr = 1;
			}
			prev = arr[i];
			ans = Math.max(ans, curr);
		}
		return ans;
	}

}
