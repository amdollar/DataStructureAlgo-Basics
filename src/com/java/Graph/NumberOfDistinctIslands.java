package com.java.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s 
 * (horizontally or vertically) forms an island. 
 * 
 * Two islands are considered to be distinct if and only if one island is not equal 
 * to another (not rotated or reflected)*/

/*
 * This is extended version of Number Of Islands problem, 
 * Here we need to somehow identify the shape of Islands that we are traversing.
 * 
 * We can plan to store the shapes of all the Islands and then identify the unique once.
 * 
 * We can create one HashSet and in that we can store the indentation of all the traverser (Paths). 
 * In the end the Set will only  contain the Unique paths. 
 * 
 */

public class NumberOfDistinctIslands {

	public static void main(String[] args) {
//		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };

//		int[][] grid = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };

		int[][] grid = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };

		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		int[][] visited = new int[n][m];

		HashSet<ArrayList<String>> paths = new HashSet<>();
		// for each dfs from one starting path we need to store it in the paths.

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					ArrayList<String> currentPath = new ArrayList<>();
					dfs(visited, grid, currentPath, i, j, i, j, n, m);
					Collections.sort(currentPath);
					paths.add(currentPath);
				}
			}
		}
		System.out.println(paths.size());

	}

	private static void dfs(int[][] visited, int[][] grid, ArrayList<String> currentPath, int row, int col,
			int insideRow, int insideCol, int n, int m) {

		int deltarow[] = { -1, 0, 1, 0 };
		int deltacol[] = { 0, 1, 0, -1 };
		visited[insideRow][insideCol] = 1;

		int difrow = insideRow - row;
		int difcol = insideCol - col;

		currentPath.add(Integer.toString(difrow) + " " + Integer.toString(difcol));

		for (int i = 0; i < 4; i++) {
			int currow = insideRow + deltarow[i];
			int curcol = insideCol + deltacol[i];

			if (currow >= 0 && currow < n && curcol >= 0 && curcol < m && grid[currow][curcol] == 1
					&& visited[currow][curcol] == 0) {

				dfs(visited, grid, currentPath, row, col, currow, curcol, n, m);
			}
		}

	}

}
