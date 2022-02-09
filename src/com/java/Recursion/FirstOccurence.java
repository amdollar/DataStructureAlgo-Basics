package com.java.Recursion;

public class FirstOccurence {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5 ,4};
		int num = 4;
		System.out.println(ifExists(arr, 0, num));
		System.out.println(getIndexRecursivly(arr, 0, arr.length, num));
	}

	private static int getIndexRecursivly(int[] arr, int index, int length, int num) {
		// base case;
		if (length == 0) {
			return -1;
		}
		if (arr[index] == num) {
			return 0;
		} // returning 0 so that it can be added with the result of more recursive calls.

		// recursive case
		int resIndex = getIndexRecursivly(arr, index + 1, length - 1, num);

		if (resIndex != -1) {
			return resIndex + 1;
		}
		//
		return -1;
	}

	// base case:
	private static boolean ifExists(int[] arr, int index, int num) {
		if (index >= arr.length) {
			return false;
		}
		if (arr[index] == num) {
			return true;
		}
		return ifExists(arr, index + 1, num);
	}

}
