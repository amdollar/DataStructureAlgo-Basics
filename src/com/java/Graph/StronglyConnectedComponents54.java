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
		for (int i = 0; i < V; i++) {
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

		// Reverse all the edges:
		// we can create another representation of the graph and move all edges in
		// reverse:

		List<List<Integer>> graphT = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graphT.add(new ArrayList<>());
		}

		for (int i = 0; i < V; i++) {
			visited[i] = 0;
			for (Integer adj : graph.get(i)) {
				graphT.get(adj).add(i);
			}
		}

		// Perform the DSF again and count the scc:
		int scc = 0;

		while (!dfs.isEmpty()) {
			int temp = dfs.pop();
			if (visited[temp] == 0) {
				scc++;
				lastDfs(graphT, visited, temp);

			}
		}
		System.out.println(scc);
	}

	private static void lastDfs(List<List<Integer>> graph, int[] visited, int node) {
		visited[node] = 1;
		for (Integer adj : graph.get(node)) {
			if (visited[adj] == 0) {
				lastDfs(graph, visited, adj);
			}
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
