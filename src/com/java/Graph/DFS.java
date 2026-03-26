package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		// create a graph
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> adj = new ArrayList<>();

		int vertex = sc.nextInt();
		int edges = sc.nextInt();

		for (int i = 0; i <= vertex; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i <= edges; i++) {
			// inputs will be vertex and we need to define edges b/w them
			int v = sc.nextInt();
			int u = sc.nextInt();

			adj.get(v).add(u);
			adj.get(u).add(v);

		}
		printGraph(adj, vertex, edges);
		// call method for DFS

		dfs(adj, vertex, edges);

	}

	private static void dfs(List<List<Integer>> adj, int vertex, int edges) {
		System.out.println("Prinitng DFS for given graph");
		// create one boolean array for tracking purpose:
		boolean[] visited = new boolean[vertex + 1];
		// Result array for the DFS printing in the end:
		List<Integer> result = new ArrayList<>();
		int startNode = 1;

		result = dfsUtils(adj, visited, result, startNode);
		System.out.println(result);

	}

	private static List<Integer> dfsUtils(List<List<Integer>> adj, boolean[] visited, List<Integer> result,
			int startNode) {

		// Since we have started the DFS now, we have marked the starting node as
		// visited.
		visited[startNode] = true;
		result.add(startNode);

		for (int neighbour : adj.get(startNode)) {
			if (!visited[neighbour]) {
				dfsUtils(adj, visited, result, neighbour);
			}
		}
		return result;

	}

	private static void printGraph(List<List<Integer>> adj, int vertex, int edges) {
		for (int i = 0; i <= vertex; i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
