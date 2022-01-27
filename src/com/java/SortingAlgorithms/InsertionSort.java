package com.java.SortingAlgorithms;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = new int[] { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		System.out.println("Before sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);
		}
		sortUsingInsertionSort(arr);
		System.out.println("\n After sorting: ");
		for (int i : arr) {
			System.out.print(" " + i);

		}

	}

	private static void sortUsingInsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];//3//-1
			int prev = i - 1; //0 //2

			while (prev >= 0 && arr[prev] > current) { // true && false
				arr[prev + 1] = arr[prev];
				prev--;
			}
			arr[prev + 1] = current;//
		}
	}
}
