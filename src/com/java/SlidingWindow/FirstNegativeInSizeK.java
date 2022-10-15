package com.java.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInSizeK {

	public static void main(String[] args) {
		int arr[] = new int[] { 12, -1, -7, 8, -10, 30, 16, -28 };
		int k = 3;
		List<Integer> res = solve(arr, arr.length, k);
		System.out.println(res);

	}

	private static List<Integer> solve(int[] arr, int length, int k) {
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> tem = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (j < length) {
			int curr = arr[j];
			if (curr < 0) {
				tem.add(curr);
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (tem.size() != 0 && arr[i] == tem.get(0)) {
					res.add(tem.get(0));
					tem.remove(0);
				} else if (tem.size() != 0 && arr[i] != tem.get(0)) {
					res.add(tem.get(0));
				}
				i++;
				j++;
			}
		}
		return res;
	}

//	private static List<Integer> solve(int[] arr, int length, int k) {
//		List<Integer> ans = new ArrayList<>();
//		for (int i = 0; i <= length - 3; i++) {
//			for (int j = i; j < i + k; j++) {
//				if (arr[j] < 0) {
//					ans.add(arr[j]);
//					break;
//				}
//			}
//		}
//		return ans;
//	}

}
