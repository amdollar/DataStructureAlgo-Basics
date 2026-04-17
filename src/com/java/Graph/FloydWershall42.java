package com.java.Graph;

import java.util.Arrays;

//https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42
public class FloydWershall42 {

	// Task is to find the shortest path b/w each pair

	public static void main(String[] args) {
//		int[][] matrix = { { 0, 2, -1, -1 }, { 1, 0, 3, -1 }, { -1, -1, 0, 1 }, { 3, 5, 4, 0 } };

		int[][] matrix = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };

		int n = matrix.length;
//		int m = matrix.length;
		// each inner array represents a row in matrix

		// since question asks for in-place, we are modifying the same input matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
//					matrix[i][j] = Integer.MAX_VALUE;// This is causing integer max issue. so changing to other large
					// value
					matrix[i][j] = (int) 1e9;
				}
				if (i == j) {
					matrix[i][j] = 0;
				}
			}
		}

		// Now start filling the cost matrix with calculations, via each of the vertex

		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Math.min(matrix[i][via] + matrix[via][j], matrix[i][j]);
				}

			}
		}

		// In case there is no way to reach convert it back to -1 as in input
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == (int) 1e9) {
					matrix[i][j] = -1;
				}
			}
		}

		for (int[] temp : matrix) {
			for (int i : temp) {
				System.out.print(" " + i);
			}
			System.out.println();
		}

	}

}
