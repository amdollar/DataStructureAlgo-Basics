package com.java.DynamicProgramming;

public class SubsetSum {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 7, 8, 10 };
		int sum = 11;
		boolean exists = subSetSum(array, sum, array.length);
		System.out.println(exists);
	}

	private static boolean subSetSum(int[] array, int sum, int length) {

		if (length == 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}

		if (array[length - 1] > sum) {
			return subSetSum(array, sum, length - 1);
		}
		return subSetSum(array, sum - array[length - 1], length - 1) || subSetSum(array, sum, length - 1);

	}

}
