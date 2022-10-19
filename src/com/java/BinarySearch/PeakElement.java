package com.java.BinarySearch;

// given an unsorted array, find the peak element in that array:
// peak element: the element which is greater than both it's neighbors
// In case of more than one , return any one.
// in 0th or nth index cases only compare with 1st and n-1th elements respectively. 
public class PeakElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1 };
		int peakElementIndex = findPeakElement(arr);
		System.out.println(peakElementIndex);
	}

	private static int findPeakElement(int[] arr) {
		int n = arr.length - 1;
		if (n == 0) {
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (mid == 0) {
				if (arr[mid] > arr[1]) {
					return 0;
				} else {
					return 1;
				}
			} else if (mid == n) {
				if (arr[mid] > arr[mid - 1]) {
					return n;
				} else {
					return n - 1;
				}
			} else if ((mid - 1 != 0 || mid + 1 != n + 1) && (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])) {
				return mid;
			} else if (arr[mid + 1] > arr[mid]) {
				start = mid + 1;
			} else if (arr[mid - 1] > arr[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}

}
