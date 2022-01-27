package com.java.SortingAlgorithms;

public class CountingSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 7, 3, 4, 3 };
		System.out.println("Before sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);
		}
		sortUsingCountingSort(arr);
		System.out.println("\n After sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);

		}
	}

	private static void sortUsingCountingSort(int[] arr) {
		// find max element
		int maxele = -1;
		for (int i : arr) {
			maxele = Math.max(i, maxele);
		}

		// create frequency array and insert frequency in that
		int feq[] = new int[maxele + 1];

		for (int i = 0; i < arr.length; i++) {
			feq[arr[i]]++;
		}
		// insert no of times in original array at frequency array's index
		// [0,0,0,2,1,1,0,1]
		int arrpointer = 0;
		for (int i = 0; i < feq.length; i++) {
			while (feq[i] > 0) {
				arr[arrpointer] = i;
				arrpointer++;
				feq[i]--;
			}
		}
	}

}
