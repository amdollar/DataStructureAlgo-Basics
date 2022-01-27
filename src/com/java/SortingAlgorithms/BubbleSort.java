package com.java.SortingAlgorithms;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = new int[] { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		System.out.println("Before sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);
		}
		sortUsingBubbleSort(arr);
		System.out.println("\n After sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);
		}
	}

	/*
	 * @Documented running this loop length - times -1 times because after every
	 * iteration (times) loop, last element of the array is at correct place so we
	 * can negate that element for comparison and swapping.
	 * 
	 * Time complexity : O(n ^ 2) | Space complexity : O(1)
	 */
	private static void sortUsingBubbleSort(int[] arr) {
		for (int times = 0; times < arr.length; times++) {
			for (int j = 0; j < arr.length - times - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
