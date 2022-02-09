package com.java.Recursion;

public class SortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 13, 4, 5 };
		System.out.println(isSorted(arr, arr.length));
		System.out.println(isSorted(arr, 0, arr.length));

	}

	private static boolean isSorted(int[] arr, int length) {
		// base case : if arr lengh is 1 or or 0 now.
		if (length == 0 || length == 1)
			return true;

		if (arr[length - 2] < arr[length - 1] && isSorted(arr, length - 1)) {
			return true;
		}
		return false;
	}

	// method 2
	private static boolean isSorted(int arr[], int i, int length) {
		if (i == length - 1) {
			return true;
		}
		if (arr[i] < arr[i + 1] && isSorted(arr, i + 1, length)) {
			return true;
		}
		return false;
	}

}
