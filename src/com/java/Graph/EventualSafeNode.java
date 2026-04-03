package com.java.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventualSafeNode {

	public static void main(String[] args) {

		int[][] grid = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		int n = grid.length;

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			for (int temp : grid[i]) {
				graph.get(i).add(temp);
			}
		}

		int[] visited = new int[n];
		int[] path = new int[n];

		Set<Integer> res = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				if (dfs(graph, visited, path, res, i)) {
					System.out.println("There is a cycle in this path.");
				}
			}
		}
		
		for (int temp : res) {
			System.out.println(temp + " , ");
		}

	}

	private static boolean dfs(List<List<Integer>> grid, int[] visited, int[] path, Set<Integer> res, int node) {

		visited[node] = 1;
		path[node] = 1;

		for (int neighbour : grid.get(node)) {
			if (visited[neighbour] == 0) {
				if (dfs(grid, visited, path, res, neighbour)) {
					return true;
				}
			} else if (path[neighbour] == 1) {
				return true;
			}
		}
		path[node] = 0;
		res.add(node);
		return false;
	}

}
