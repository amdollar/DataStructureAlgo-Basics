package com.java.BinarySearch;

public class MinInSortedRotatedArr {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 1 };
		int res = findMin(arr);
		System.out.println(res);
	}

	private static int findMin(int[] arr) {
		int n = arr.length;
		if (n == 1) {
			return arr[0];
		}
		int start = 0;
		int res = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;
			if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
				return arr[mid];
			} else if (arr[mid] >= arr[end]) {
				start = next;
			} else {
				end = prev;
			}
		}
		return res;
	}
}