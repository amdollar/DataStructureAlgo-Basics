package com.java.Graph;

/*You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. 
 * You are also given three integers sr, sc, and color. 
 * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].*/
public class FloodFill {

	public static void main(String[] args) {
		int[][] graph = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		int sr = 1;
		int sc = 1;
		int color = 2;

		System.out.println("Before Flood Fill: ");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		int[][] res = floodFill(graph, sr, sc, color);

		System.out.println("After Flood Fill: ");
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] floodFill(int[][] graph, int sr, int sc, int color) {

		// find the current color of the source point.
		int currentColor = graph[sr][sc];
		// Create new graph instead of ruining input
		int[][] graphcopy = graph;

		int[] deltarow = { -1, 0, 1, 0 };
		int[] deltacol = { 0, 1, 0, -1 };

		dfs(graphcopy, sr, sc, color, deltarow, deltacol, currentColor);
		return graphcopy;
	}

	private static void dfs(int[][] ans, int sr, int sc, int newColor, int[] deltarow, int[] deltacol,
			int currentColor) {

		ans[sr][sc] = newColor;

		for (int i = 0; i < 4; i++) {
			int currow = sr + deltarow[i];
			int curcol = sc + deltacol[i];

			if (currow >= 0 && currow < ans.length && curcol >= 0 && curcol < ans[0].length
					&& ans[currow][curcol] == currentColor && ans[currow][curcol] != newColor) {
				dfs(ans, currow, curcol, newColor, deltarow, deltacol, currentColor);
			}
		}

	}

}
