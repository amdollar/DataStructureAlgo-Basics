package com.java.BinarySearch;

// In the given array and one element ele, find  out the element from the array whose difference is minimum when reduced with ele.  
public class MinDiffSortedArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 6, 10 };
		int ele = 7;
		int res = minDiffElement(arr, ele);
		System.out.println(res);
	}

	private static int minDiffElement(int[] arr, int ele) {
		int start = 0;
		int diff = Integer.MAX_VALUE;
		int n = arr.length - 1;
		int ans = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == ele) {
				return arr[mid];
			} else if (arr[mid] > ele) {
				end = mid - 1;
			} else if (arr[mid] < ele) {
				start = mid + 1;
			}
		}
		int abs1 = Math.abs(ele - arr[start]);
		int abs2 = Math.abs(ele - arr[end]);
		if (abs1 > abs2) {
			ans = arr[end];
		} else {
			ans = arr[start];
		}
		return ans;
	}

}
