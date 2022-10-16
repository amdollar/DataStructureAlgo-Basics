package com.java.BinarySearch;

public class FindInRotatedSortedArray {
	public static void main(String[] args) {
		int arr[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int ele = 2;
		int res = findInSortedRotated(arr, ele);
		System.out.println(res);
	}

	private static int findInSortedRotated(int[] arr, int ele) {
		int midindex = indexOfMinElement(arr);
		int ans = -1;
		int ans1 = bst(0, midindex - 1, ele, arr);
		if (ans1 > -1) {
			ans = ans1;
			return ans;
		}
		int ans2 = bst(midindex, arr.length - 1, ele, arr);
		if (ans2 > -1) {
			ans = ans2;
			return ans;
		}
		return ans;
	}

	private static int bst(int start, int end, int ele, int[] arr) {
		int res = -1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == ele) {
				res = mid;
				return res;
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else if (arr[mid] < ele) {
				start = mid + 1;
			}
		}
		return res;
	}

	private static int indexOfMinElement(int[] arr) {
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
				return mid;
			} else if (arr[mid] >= arr[end]) {
				start = next;
			} else {
				end = prev;
			}
		}
		return res;
	}
}
