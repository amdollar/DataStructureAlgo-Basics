package com.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurriundedRegions {

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {

		// WE need to replace all the O's (regions) with X when that region is not
		// touching the boundary (i.e.: Then only we can say it is Surrounded by 'X').
		char[][] grid = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		Queue<Pair> queue = new LinkedList<>();

		// 1. We need to create a copy answer array instead of modifying the input one:

		int n = grid.length;
		int m = grid[0].length;
		char[][] copy = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = grid[i][j];
			}
		}

		// 2. Create a visited array to mark the boundary 'O' as visited.
		// also, Put all the Pairs in the queue that are having 'O' and are at the
		// Boundary:

		int[][] visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'O' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
					queue.offer(new Pair(i, j));
					visited[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println("");
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println("");
		}

		// 3. Perform DFS for the 'O' that are visited and mark them as done.

		int[] deltarows = { -1, 0, 1, 0 };
		int[] deltacols = { 0, 1, 0, -1 };

		dfs(copy, visited, deltarows, deltacols, queue, n, m);

		// we need to now treverse the input array and if 'O' != 1 we mark it as 'X'

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println("");
		}

		// 4. At the end, mark all the non visited 'O' in the result grid as 'X'

	}

	private static void dfs(char[][] copy, int[][] visited, int[] rows, int[] cols, Queue<Pair> queue, int n, int m) {

		while (!queue.isEmpty()) {
			int row = queue.peek().first;
			int col = queue.peek().second;
			queue.remove();

			for (int i = 0; i < 4; i++) {
				int currow = row + rows[i];
				int curcol = col + cols[i];

				if (currow >= 0 && currow < n && curcol >= 0 && curcol < n && copy[currow][curcol] == 'O'
						&& visited[currow][curcol] != 1) {
					visited[currow][curcol] = 1;
					queue.offer(new Pair(currow, curcol));
				}

			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] != 1 && copy[i][j] == 'O') {
					copy[i][j] = 'X';
				}

			}
		}

	}

	// code for final marking:

}
