package com.java.Recursion;

//https://principal.udemy.com/course/cpp-data-structures-algorithms-prateek-narang/learn/lecture/26672892#overview
public class LastOccurance {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 4 };
		int num = 4;
		System.out.println(getLastIndexRecursivly(arr, 0, arr.length, num));
	}

	private static int getLastIndexRecursivly(int[] arr, int index, int length, int num) {
		// base case;
		if (length == 0) {
			return -1;
		}
		int subIndex = getLastIndexRecursivly(arr, index + 1, length - 1, num);
		if (subIndex == -1) {
			if (arr[index] == num) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return subIndex + 1;
		}

	}

}
