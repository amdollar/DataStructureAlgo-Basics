package com.java.SortingAlgorithms;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 7, 3, 4, 3 };
		System.out.println("Before sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);
		}
		sortUsingSelectionSort(arr);
		System.out.println("\n After sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);

		}
	}

	private static void sortUsingSelectionSort(int[] arr) {
// if we sort the array till n-1 then this outer loop needs to run till n-2 only
		for (int pos = 0; pos <= arr.length - 2; pos++) {
			int min = arr[pos];
			int minpos = pos;
			// find min element from the unsorted arr pos+1
			for (int i = pos + 1; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					minpos = i;
				}
			}
			// do the swapping part here with current and min.
			arr[minpos] = arr[pos];
			arr[pos] = min;
		}
	}

}
