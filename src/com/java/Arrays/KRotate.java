package com.java.Arrays;

public class KRotate {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9 };
		int k = 2;
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
		rotateArr(arr, k);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	private static void rotateArr(int[] arr, int k) {
		while (k > 0) {
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 2; i >= 0; i--) {
				arr[i + 1] = arr[i];
			}
			arr[0] = temp;
			k--;
		}
	}

}
