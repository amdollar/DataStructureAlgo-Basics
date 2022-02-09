package com.java.BitManipulation;

public class FindDuplicate {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 1, 2, 3, 4 };
		int duplicate = findDuplicate(arr);
		System.out.println(duplicate);
	}

	private static int findDuplicate(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int xored = (arr[i]) ^ (arr[i + 1]);
			if (xored == 0) {
				return arr[i + 1];
			}
		}
		return -1;
	}

}
