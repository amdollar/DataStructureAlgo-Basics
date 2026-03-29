package com.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pairr {
	int first;
	int second;

	Pairr(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class NoOfIcelands {

	public static void main(String[] args) {
//		int[][] grid = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };

		int vertex = grid.length;
		int edges = grid[0].length;

		// Print the grid to get some visual idea;

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < edges; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		// we need to run a bfs on this and while doing that we need to make sure all
		// the 8 directions are being covered

		int visited[][] = new int[vertex][edges];
		int count = 0;
		for (int row = 0; row < vertex; row++) {
			for (int col = 0; col < edges; col++) {
				if (visited[row][col] == 0 && grid[row][col] == 1) {
					count++;
					bfs(grid, row, col, visited);
				}
			}
		}
		System.out.println("Number of Islands : " + count);

	}

	private static void bfs(int[][] grid, int startRow, int startCo, int[][] visited) {
		Queue<Pairr> queue = new LinkedList<>();
		int n = grid.length;
		int m = grid[0].length;
		visited[startRow][startCo] = 1;
		queue.add(new Pairr(startRow, startCo));

		while (!queue.isEmpty()) {
			int row = queue.peek().first;
			int col = queue.peek().second;
			queue.remove();

			for (int delrow = -1; delrow <= +1; delrow++) {
				for (int delcol = -1; delcol <= 1; delcol++) {
					int currow = row + delrow;
					int curcol = col + delcol;

					if (currow >= 0 && currow < n && curcol >= 0 && curcol < m && visited[currow][curcol] == 0
							&& grid[currow][curcol] == 1) {
						visited[currow][curcol] = 1;
						queue.add(new Pairr(currow, curcol));

					}
				}
			}
		}

	}

}
