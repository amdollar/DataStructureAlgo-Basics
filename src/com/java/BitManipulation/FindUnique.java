package com.java.BitManipulation;

public class FindUnique {
// Using this XOR operation find the unique element in the given array;
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 2, 1 };
		int ans = findUniqueNumber(arr);
		System.out.println("Unique number in the given array is: " + ans);
	}

	private static int findUniqueNumber(int[] arr) {
		int temp = 0;
		for (int i : arr) {
			temp = temp ^ i;
		}
		return temp;
	}

}
