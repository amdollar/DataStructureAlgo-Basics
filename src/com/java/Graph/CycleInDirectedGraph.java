package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {

	static class Pair {
		int node;
		int weight;

		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> graph = new ArrayList<>();

		int V = 4;

		// create empty adj list that will represent the graphs:
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		// WE need to create a edge based graph in the adj list:

		graph.get(0).add(1);
		graph.get(1).add(2);
		graph.get(2).add(3);
		graph.get(3).add(1);

		for (int i = 0; i < V; i++) {
			System.out.print(i + " ->");
			for (int node : graph.get(i)) {
				System.out.print(node + " ");
			}
			System.out.println();
		}

		System.out.println(detectCycle(graph));

	}

	private static boolean detectCycle(List<List<Integer>> graph) {
		// we can perform any type of traversal on the graph and while doing that if we
		// somehow are able to track the Path taken for the traversal
		// we can find out the cycle in the graph.
		int n = graph.size();
		int[] visited = new int[n];
		int[] path = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(graph, visited, path, i);
				return true;
			}
		}

		return false;

	}

	private static boolean dfs(List<List<Integer>> graph, int[] visited, int[] path, int node) {
		visited[node] = 1;
		path[node] = 1;

		for (int neighbour : graph.get(node)) {
			if (visited[neighbour] == 0) {
				if (dfs(graph, visited, path, neighbour))
					return true;
			} else if (path[neighbour] == 1) {
				return true;
			}
		}

		// so that it is removed from the path, in case if this Node is coming again in
		// another Path, this should not be considered as Cycle;
		path[node] = 0;
		return false;

	}

}
