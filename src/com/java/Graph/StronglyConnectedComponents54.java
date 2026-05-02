package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 
public class StronglyConnectedComponents54 {

	public static void main(String[] args) {
		int V = 5;
		int E = 5;
		int edges[][] = { { 0, 2 }, { 0, 3 }, { 1, 0 }, { 2, 1 }, { 3, 4 } };

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < edges.length; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			graph.get(start).add(end);
		}

		// Sort the edges of graph according to the finishing time:
		Stack<Integer> dfs = new Stack<>();
		int[] visited = new int[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == 0)
				dfs(graph, visited, dfs, i);
		}

	}

	private static void dfs(List<List<Integer>> graph, int[] visited, Stack<Integer> dfs, int node) {
		visited[node] = 1;
		for (Integer adj : graph.get(node)) {
			if (visited[adj] == 0) {
				dfs(graph, visited, dfs, adj);
			}
		}
		dfs.push(node);

	}

}
