package com.java.BinarySearch;

public class PosInBinraySorted {
	// find the position of first 1 in given Binary Sorted Infinite Array:
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 1, 1, 1, 1, 1 };
		int resIndex = findFirstOne(arr, 1);
		System.out.println(resIndex);
	}

	private static int findFirstOne(int[] arr, int element) {
		int start = 0;
		int end = 1;
		while (arr[end] < element) {
			start = end;
			end = end * 2;
		}
		return findFirstUsingBS(start, end, element, arr);
	}

	private static int findFirstUsingBS(int start, int end, int element, int[] arr) {
		int res = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == element) {
				if (mid < res) {
					res = mid;
				}
				end = mid - 1;
			} else if (arr[mid] > element) {
				end = mid - 1;
			} else if (arr[mid] < element) {
				start = mid + 1;
			}
		}
		return res;
	}

}
