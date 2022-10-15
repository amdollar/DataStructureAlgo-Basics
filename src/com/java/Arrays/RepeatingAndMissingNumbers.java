package com.java.Arrays;

public class RepeatingAndMissingNumbers {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1, 2, 5, 4, 6, 7, 5 };
		int res[] = solve(arr, arr.length);
		for (int i : res)
			System.out.println(i);
	}

	private static int[] solve(int[] arr, int length) {
		return findRepeatingElement(arr, length);

	}

	private static int[] findRepeatingElement(int[] arr, int length) {
		// solve using frequency array:
		int res[] = new int[2];
		int[] feq = new int[length + 1];
		for (int i = 1, j = 0; i <= length; i++, j++) {
			feq[arr[j]]++;
		}

		for (int i = 1; i < feq.length; i++) {
			if (feq[i] > 1) {
				res[0] = i;
			} else if (feq[i] == 0) {
				res[1] = i;
			}
		}
		return res;
	}

}
