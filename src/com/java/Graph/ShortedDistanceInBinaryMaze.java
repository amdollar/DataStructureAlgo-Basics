package com.java.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
public class ShortedDistanceInBinaryMaze {

	// This will represent the single Record {dis, row, col} for the grid that we
	// will be storing in the PQ for easy processing.
	static class Tuple {
		int dis;
		int row;
		int col;

		Tuple(int dis, int row, int col) {
			this.dis = dis;
			this.row = row;
			this.col = col;

		}
	}

	public static void main(String[] args) {

//		int[][] grid = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 } };
		int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 }, { 1, 0, 1, 0, 1 } };
		int[] source = { 0, 0 };
		int[] distination = { 3, 4 };
		int n = grid.length;
		int m = grid[0].length;

		// WE would need one distance array to capture and compare the distance while
		// processing/traversing the nodes

		int[][] dis = new int[n][m];
		for (int[] row : dis)
			Arrays.fill(row, Integer.MAX_VALUE);

		dis[source[0]][source[1]] = 0;
		int ansSteps = -1;

//		We need a Queue to process all the nodes since we are going to use BFS:

		int[] deltarows = { -1, 0, +1, 0 };
		int[] deltacols = { 0, +1, 0, -1 };

		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(0, source[0], source[1]));

		while (!queue.isEmpty()) {
			Tuple curr = queue.poll();
			int c_dis = curr.dis;
			int c_row = curr.row;
			int c_col = curr.col;

			if (c_row == distination[0] && c_col == distination[1]) {
				ansSteps = c_dis;
			}

			// Mark this tile of grid as visited/distance
//			dis[c_row][c_col] =  c_dis;

			for (int i = 0; i < deltarows.length; i++) {
				int new_row = c_row + deltarows[i];
				int new_col = c_col + deltacols[i];

				if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m
						&& dis[new_row][new_col] == Integer.MAX_VALUE && grid[new_row][new_col] != 0) {
					dis[new_row][new_col] = c_dis + 1;
					queue.add(new Tuple(c_dis + 1, new_row, new_col));
				}

			}
		}
		System.out.println("Total distance/ steps : " + ansSteps);

	}
}
