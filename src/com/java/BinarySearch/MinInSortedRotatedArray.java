package com.java.BinarySearch;

public class MinInSortedRotatedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 8, 11, 12, 15, 18, 22, 2, 5, 6 };
		int res = findMinEle(arr);
		System.out.println(res);
	}

	private static int findMinEle(int[] arr) {
		int start = 0;
		int res = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid - 1] > arr[mid]) {
				res = arr[mid];
				return mid;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}
	


}
