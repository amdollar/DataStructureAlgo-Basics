package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraph {

	public static void main(String[] args) {
		int V = 4;
		int[][] grid = { { 0, 1 }, { 1, 2 } };
		int n = grid.length;
		int m = grid[0].length;

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			int u = grid[i][0];
			int v = grid[i][1];

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		for (List<Integer> a : adj) {
			for (int i : a) {
				System.out.print(i);
			}
			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		int[] color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = -1;

		boolean isBipartite = true;
		for (int i = 0; i < V; i++) {
			if (color[i] == -1)
				if (dfs(adj, color, i, 0) == false) {
					isBipartite = false;
					break;
				}
		}
		if (isBipartite)
		    System.out.println("Is a bipartite graph.");
		else
		    System.out.println("Not a bipartite graph");

	}

	private static boolean dfs(List<List<Integer>> adj, int[] color, int node, int initclr) {
		color[node] = initclr;

		for (int neighbour : adj.get(node)) {
			if (color[neighbour] == -1) {
				if (dfs(adj, color, neighbour, 1 - initclr) == false)
					return false;

			} else {
				if (color[neighbour] == initclr) {
					return false;
				}

			}
		}
		return true;

	}
}
