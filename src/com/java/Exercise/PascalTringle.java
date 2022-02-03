package com.java.Exercise;

public class PascalTringle {

	public static void main(String[] args) {
		int n = 6;
		int[][] tringle = printPascalTringle(n);
		for (int i = 0; i < tringle.length; i++) {
			for (int j = 0; j < tringle[i].length; j++) {
				System.out.print(tringle[i][j]);
			}
			System.out.println();
		}
	}

	private static int[][] printPascalTringle(int n) {
		int[][] arr = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col <= row; col++) {
				if (col == 0 || col == row) {
					arr[row][col] = 1;
					System.out.print("1");
				} else {
					arr[row][col] = arr[row - 1][col - 1] + arr[row - 1][col];
					System.out.print(arr[row][col]);
				}
			}
			System.out.println();
		}
		return arr;
	}

}
