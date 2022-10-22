package com.java.BinarySearch;

// Bitonic Array: A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.

// search in Bitonic Array: given an bitonic array and one element, find out the index of given element.

public class ElementInBitonicArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 6, 7, 8, 9, 10, 3, 2, 1 };
		int element = 30;
		int maxIndex = findMax(arr);
		System.out.println("Max element index in array : " + maxIndex);
		// once we get the peak element, we know as per the definition we know that the
		// left and right parts of
		// the array would be sorted. So apply Binary search on those parts
		int index1 = bsOnLeftPart(arr, 0, maxIndex, element);
		int index2 = bsOnRightPart(arr, maxIndex + 1, arr.length - 1, element);
		if (index1 == index2) {
			System.out.println(-1);
		} else {
			int res = index1 == -1 ? index2 : index1;
			System.out.println(res);
		}
	}

	private static int bsOnRightPart(int[] arr, int start, int end, int element) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] > element) {
				start = mid + 1;
			} else if (arr[mid] < element) {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int bsOnLeftPart(int[] arr, int start, int end, int element) {
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

	// max element in bitonic element is nothing but the Peak element;
	private static int findMax(int[] arr) {
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
