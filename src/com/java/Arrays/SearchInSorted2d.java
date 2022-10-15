package com.java.Arrays;

public class SearchInSorted2d {
	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 60;
		System.out.println(searchIn2DMatrix(matrix, target));
	}

	private static boolean searchIn2DMatrix(int[][] matrix, int target) {
		int j = matrix[0].length - 1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] <= target && matrix[i][j] >= target) {
				return searchInCurrent(i, j, matrix, target);
			}
		}
		return false;
	}

	private static boolean searchInCurrent(int i, int j, int[][] matrix, int target) {
		for (int k = i; k <= j; k++) {
			if (matrix[i][k] == target) {
				return true;
			}
		}
		return false;
	}
}