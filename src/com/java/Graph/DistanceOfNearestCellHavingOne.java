package com.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {

	static class Pair {
		int row;
		int col;
		int distance;

		Pair(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {

//		int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
		int[][] grid = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };

		// we need to find our the distance of nearest 1 from each cell.
		// |i1 - i2| + |j1 - j1|

		// from each 1 we can start performing BFS, in this case we have to store the
		// pair with r,c and distance

		// BFS: 1. Visited array, 2. Queue with Pair 3. duplicate input grid,
		int n = grid.length;
		int m = grid[0].length;
		int[][] graph = new int[n][m];
		int[][] visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = grid[i][j];
			}
		}

		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					graph[i][j] = 0;
					visited[i][j] = 1;
					queue.offer(new Pair(i, j, 0));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		int[] deltaRows = { 0, -1, 0, 1 };
		int[] deltaCols = { 1, 0, -1, 0 };

		int tmDistance = 0;
		while (!queue.isEmpty()) {
			int row = queue.peek().row;
			int col = queue.peek().col;
			int distance = queue.peek().distance;

			tmDistance = Math.max(distance, tmDistance);

			queue.remove();

			for (int i = 0; i < 4; i++) {
				int currow = row + deltaRows[i];
				int curcol = col + deltaCols[i];

				if (currow >= 0 && currow < n && curcol >= 0 && curcol < m && visited[currow][curcol] != 1
						&& grid[currow][curcol] == 0) {
					if (graph[currow][curcol] == 0) {
						visited[currow][curcol] = 1;
						tmDistance = distance + 1;
						graph[currow][curcol] = tmDistance;
						queue.offer(new Pair(currow, curcol, distance + 1));
					}
				}
			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Max: " + tmDistance);

	}

}
