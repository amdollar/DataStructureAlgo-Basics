package com.java.Graph;

//https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42
public class FloydWershall42 {

	// Task is to find the shortest path b/w each pair

	public static void main(String[] args) {
//		int[][] matrix = { { 0, 2, -1, -1 }, { 1, 0, 3, -1 }, { -1, -1, 0, 1 }, { 3, 5, 4, 0 } };

		int[][] matrix = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };

		int n = matrix[0].length;
		int m = matrix.length;
		// each inner array represents a row in matrix

		// Step 1. have one weight ajd array:
		int[][] cost = new int[n][m];

	}

}
