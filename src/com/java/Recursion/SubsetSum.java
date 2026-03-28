package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

// find the sum of all the subsets of given array
public class SubsetSum {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 4, 5 };
		int index = 0;
		int length = arr.length;
		int sum = 0;
		subsetSum(arr, index, length, sum);
	}

	private static void subsetSum(int[] arr, int index, int length, int sum) {

		if (index >= length) {
			System.out.println(sum);
			return;
		}

		subsetSum(arr, index + 1, length, sum + arr[index]);
		subsetSum(arr, index + 1, length, sum);
	}

}
