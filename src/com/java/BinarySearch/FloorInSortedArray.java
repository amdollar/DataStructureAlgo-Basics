package com.java.BinarySearch;

public class FloorInSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 1,  3, 4, 8, 10, 10, 12, 19 };
		int ele = 22;
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
				return mid;
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else if (arr[mid] < ele) {
				if (arr[mid] < ele && arr[mid] > res) {
					res = mid;
				}
				start = mid + 1;
			}
		}
		return res;
	}

}
