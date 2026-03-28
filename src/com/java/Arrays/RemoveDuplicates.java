package com.java.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 1, 3, 3, 4, 4, 4, 5, 5, 6, 6 };
		int j = removeDuplicates(arr);
		for (int i = 0; i < j; i++)
			System.out.println(arr[i]);
	}

	private static int removeDuplicates(int[] arr) {
		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i + 1;
	}

}
