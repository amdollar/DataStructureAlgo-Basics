package com.java.BinarySearch;

import java.util.ArrayList;
import java.util.List;

// Given a col-wise and row-wise sorted array, find the index of a given element.
public class SearchIn2DArray {

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 10 }, {10} };
		int element = 9;
		List<Integer> index = findIn2DArray(arr, element);
		System.out.println(index);

	}

	private static List<Integer> findIn2DArray(int[][] arr, int element) {
		List<Integer> indexes = new ArrayList<>();
		int i = 0;
		int ilen = arr.length - 1;
		int len = arr[0].length - 1;
		int j = len;
		while ((i >= 0 && j >= 0) && (i <= ilen && j <= len)) {
			if (arr[i][j] == element) {
				indexes.add(i);
				indexes.add(j);
				return indexes;
			} else if (arr[i][j] > element) {
				j--;
			} else if (arr[i][j] < element) {
				i++;
			}
		}

		return indexes;
	}

}
