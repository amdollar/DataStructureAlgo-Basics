package com.java.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 8, 10 };
		int arr2[] = { 2, 3, 9 };
		System.out.println("Before merge:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		merge(arr1, arr2, arr1.length, arr2.length);
		System.out.println("After merge:");
	    for (int i = 0; i < arr1.length; i++) {
	        System.out.print(arr1[i] + " ");
	      }
	      System.out.println();
	      for (int i = 0; i < arr2.length; i++) {
	        System.out.print(arr2[i] + " ");
	      }
	}

	private static void merge(int[] arr1, int[] arr2, int length, int length2) {
		int i = 0;
		int j = 0;

		while (i < length) {
				if (arr1[i] > arr2[j]) {
					// swap
					swap(i, j, arr1, arr2);
					// sort the second array;
					Arrays.sort(arr2);
				}
				i++;
		}
	}

	private static void swap(int i, int j, int[] arr1, int[] arr2) {
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}

}
