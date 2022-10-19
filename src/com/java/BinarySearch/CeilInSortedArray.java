package com.java.BinarySearch;

public class CeilInSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 4, 8, 10, 10, 12, 19 };
		int ele = 3;
		int floor = findFloor(arr, ele);
		System.out.println(floor);
	}

	private static int findFloor(int[] arr, int ele) {
		int start = 0;
		int end = arr.length - 1;
		int res = -1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == ele) {
				return arr[mid];
			} else if (arr[mid] > ele) {
				if (arr[mid] > ele) {
					res = arr[mid];
				}
				end = mid - 1;
			} else if (arr[mid] < ele) {
				start = mid + 1;
			}
		}
		return res;
	}

}
