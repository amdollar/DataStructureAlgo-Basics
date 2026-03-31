package com.java.Graph;

/*You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.*/

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
//		int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };

		int[][] grid = { { 0 }, { 1 }, { 1 }, { 0 }, { 0 } };
		int n = grid.length;
		int m = grid[0].length;

		Queue<Pair> queue = new LinkedList<>();

		// Find the number of lands from where we can not walk off the Boundary
		// 1 = land 0 = Water.
		// We can not walk off the boundary if it is 0.

		// 1, Identify all the boundaries with 1.

		int[][] visited = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				visited[i][j] = grid[i][j];
//			}
//		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
					visited[i][j] = grid[i][j];
					queue.offer(new Pair(i, j));
				}
			}
		}
		int deltarows[] = { -1, 0, 1, 0 };
		int deltacols[] = { 0, 1, 0, -1 };

		// 2. Do the opposite traversal from the above identified boundaries towards
		// inside to mark all reachable as visited.

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}

		while (!queue.isEmpty()) {
			int row = queue.peek().first;
			int col = queue.peek().second;

			queue.remove();

			for (int i = 0; i < 4; i++) {
				int currow = row + deltarows[i];
				int curcol = col + deltacols[i];

				if (currow >= 0 && currow < n && curcol >= 0 && curcol < m && grid[currow][curcol] == 1
						&& visited[currow][curcol] != 1) {
					queue.offer(new Pair(currow, curcol));
					visited[currow][curcol] = 1;
				}
			}

		}

		// 3. Once the above is completed do a comparison with visited and input, to
		// see what land is left.
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] != 1 && grid[i][j] == 1) {
					count++;
				}
			}
		}

		System.out.println("Total number of lands: " + count);
	}

}
