package com.java.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 2, 4, 6, 0, 1));
		System.out.println(arr);
		sort(arr);
		System.out.println(arr);
	}

	private static void sort(ArrayList<Integer> arr) {
		// recursion for sorting the array
		// base condition
		if (arr.size() == 1) {
			return;
		}
		// Hypothesis (smaller inputs)
		int temp = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		sort(arr);

		// Induction: adding this element to the already sorted array at it's correct
		// position.
		insert(arr, temp);

	}

	private static void insert(ArrayList<Integer> arr, int temp) {
		// base condition
		if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
			arr.add(temp);
			return;
		}
		// Hypothesis
		int last = arr.size() - 1;
		arr.remove(arr.size() - 1);
		insert(arr, temp);

		// induction
		arr.add(last);
	}

}
