package com.java.BinarySearch;

public class FindInInfiniteArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int element = 140;
		int res = findPos(arr, element);
		System.out.println(res);

	}

// left is 0 but right we need to calculate (assume)
	// keep right at 1st index
	// compare it with the element if element is < than this right index then
	// increase right index by at-least 2x
	private static int findPos(int[] arr, int element) {
		int start = 0;
		int end = 1;
		// a null check can be done, if not infinite array
		while (arr[end] < element) {
			start = end;
			end = end * 2;
		}
		return binarySearch(arr, element, start, end);

	}

	private static int binarySearch(int[] arr, int element, int start, int end) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] > element) {
				end = mid - 1;
			} else if (arr[mid] < element) {
				start = mid + 1;
			}
		}
		return -1;
	}

}
