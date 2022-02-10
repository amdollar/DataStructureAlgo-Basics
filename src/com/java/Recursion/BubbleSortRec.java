package com.java.Recursion;

public class BubbleSortRec {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 3, 2, 3, 4, 5 };
		sortBubbleRec(arr, arr.length - 1);
		for (int i : arr) {
			System.out.print(i);
			System.out.print(", ");
		}
	}

	private static void sortBubbleRec(int[] arr, int n) {
		if (n == 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[i + 1]) {
				// swap
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
			}
		}
		sortBubbleRec(arr, n - 1);
	}

}
