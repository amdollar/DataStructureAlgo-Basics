package com.java.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxOfSizeKWind {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 3, -1, -3, 5, 6, 7 };
		List<Integer> res = new ArrayList<>();
		int k = 3;
		res = solve(arr, arr.length, k);
		System.out.println(res);

	}

	private static List<Integer> solve(int[] arr, int length, int k) {
		Queue<Integer> data = new LinkedList<>();
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (j < length) {
			data.add(arr[j]);
			int front = data.peek();
			if (front < arr[j]) {
				// remove all elements
				data.clear();
				data.offer(arr[j]);
			} else {
				data.offer(arr[j]);
			}
			// calculations
			if (j - i + 1 < k) {
				j++;
			}
			if (j - i + 1 == k) {
				// answer
				ans.add(data.peek());
				i++;
				j++;
			}
		}

		return ans;
	}

}
