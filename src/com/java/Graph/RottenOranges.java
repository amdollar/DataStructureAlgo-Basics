package com.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

class Paair {
	int first;
	int second;
	int time;

	Paair(int first, int second, int time) {
		this.first = first;
		this.second = second;
		this.time = time;
	}
}

public class RottenOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		int res = orangesRotting(grid);

		System.out.println(res);

	}

	private static int orangesRotting(int[][] grid) {
		int res = 0;
		int fresh = 0;

		Queue<Paair> queue = new LinkedList<>();

		// since we need to find the unit of times one by one, we can use BFS here

		int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = 0;
				} else if (grid[i][j] == 2) {
					queue.offer(new Paair(i, j, 0));
					visited[i][j] = 2;
				}
				if (grid[i][j] == 1)
					fresh++;
			}
		}

		int deltarows[] = { 0, 1, 0, -1 };
		int deltacols[] = { -1, 0, 1, 0 };
		int tm = 0;

		while (!queue.isEmpty()) {

			int r = queue.peek().first;
			int c = queue.peek().second;
			int t = queue.peek().time;

			tm = Math.max(tm, t);

			queue.remove();
			for (int i = 0; i < 4; i++) {
				int currow = r + deltarows[i];
				int curcol = c + deltacols[i];

				if (currow >= 0 && currow < n && curcol >= 0 && curcol < m && visited[currow][curcol] == 0
						&& grid[currow][curcol] == 1) {
					queue.add(new Paair(currow, curcol, t + 1));
					visited[currow][curcol] = 2;
					res++;

				}
			}

		}
		if (res != fresh)
			return -1;

		return tm;
	}
}
