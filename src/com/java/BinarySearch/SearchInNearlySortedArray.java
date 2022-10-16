package com.java.BinarySearch;

// Modified binary Search. 
public class SearchInNearlySortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 5, 30, 20, 40 };
		int ele = 30;
		int res = searchInNearlySortedArray(arr, ele);
		System.out.println(res);

	}

	private static int searchInNearlySortedArray(int[] arr, int ele) {
		int start = 0;
		int end = arr.length - 1;
		int res = -1;

		while (start <= end) {
			int mid = start + ((end - start) / 2);

			if (arr[mid] == ele) {
				return mid;
			} else if ((mid + 1 <= arr.length && mid - 1 >= 0) && arr[mid - 1] == ele) {
				return mid - 1;
			} else if ((mid + 1 <= arr.length && mid - 1 >= 0) && arr[mid + 1] == ele) {
				return mid + 1;
			} else if (arr[mid] > ele) {
				if (mid - 2 >= 0 || mid + 2 <= arr.length - 1)
					end = mid - 2;
			} else if (arr[mid] < ele) {
				if (mid - 2 >= 0 || mid + 2 <= arr.length - 1)
					start = mid + 2;
			}
		}

		return res;
	}

}
