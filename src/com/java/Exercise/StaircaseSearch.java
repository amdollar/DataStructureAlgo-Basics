package com.java.Exercise;

import java.util.ArrayList;
import java.util.List;

public class StaircaseSearch {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 } };
		int element = 31;
		List<Integer> index = new ArrayList<>();
		index = findIndex(arr, element);
		System.out.println(index);
	}

	private static List<Integer> findIndex(int[][] arr, int element) {
		// if element is not within the range
		List<Integer> res = new ArrayList();

		int n = arr[0].length - 1;
		int m = arr.length - 1;
		if (element < arr[0][0] || element > arr[m][n]) {
			res.add(-1);
			res.add(-1);
			return res;
		}
		// staircase algo
		int start = 0;
		int end = n;
		while (start >= 0 && end <= m) {
			if (arr[start][end] == element) {
				res.add(start);
				res.add(end);
				return res;
			} else if (arr[start][end] > element) {
				end--;
			} else if (arr[start][end] < element) {
				start++;
			}
		}

		res.add(-1);
		res.add(-1);
		return res;
	}

}
