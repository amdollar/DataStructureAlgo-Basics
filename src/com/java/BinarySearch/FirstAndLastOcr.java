package com.java.BinarySearch;

public class FirstAndLastOcr {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 4, 5, 6, 10, 10, 10, 10, 17, 18, 20 };
		int ele = 10;
		int first = firstOcr(arr, ele);
		System.out.println("First occurance of " + ele + " in array : " + first);
		int last = lastOcr(arr, ele);
		System.out.println("Last occurance of " + ele + " in array : " + last);
		int total = last - first + 1;
		System.out.println("Total number of orrurances of " + ele + " in array: " + total);

	}

	private static int firstOcr(int[] arr, int ele) {
		int start = 0;
		int res = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == ele) {
				res = mid;
				end = mid - 1;
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else if (arr[mid] < ele) {
				start = mid + 1;
			}
		}

		return res;
	}

	private static int lastOcr(int[] arr, int ele) {
		int start = 0;
		int res = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start / 2);
			if (arr[mid] == ele) {
				res = mid;
				start = mid + 1;
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else if (arr[mid] < ele) {
				start = mid + 1;
			}
		}

		return res;
	}

}
