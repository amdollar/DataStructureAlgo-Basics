package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

	static class Pair {
		int first;
		int weight;

		Pair(int first, int weight) {
			this.first = first;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };
		int N = 6;
		int M = 7;
		// We will break this problem into multiple steps:
		// 1. Find the topological sorting order of the graph from the given start node:
		// This will make sure that the node u will always calculated after v in u -> v
		// 2. While Doing the Topological ordering we need to reuse the nodes again in
		// the further processing.
		// So we wills store these nodes into Stack while working and have one visited[]
		// 3. Once the topo sort is completed we can start calculation of the Distance
		// by doing a
		// Comparison b/w two nodes (paths) starting from one source.

		// o. create an adj list representation of the edges:

		List<List<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			adj.add(new ArrayList<Pair>());
		}

		Stack<Integer> stack = new Stack<>();
		int visited[] = new int[N];

		for (int i = 0; i < M; i++) {
			int first = edges[i][0];
			int second = edges[i][1];
			int wt = edges[i][2];
			adj.get(first).add(new Pair(second, wt));
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				topoSort(adj, stack, visited, i);
			}
		}
		int sortestPath[] = new int[N];
		for (int i = 0; i < sortestPath.length; i++) {
			sortestPath[i] = Integer.MAX_VALUE;
		}

		sortestPath[0] = 0;
		while (!stack.isEmpty()) {
			int current = stack.pop();
//			System.out.println(current);
			for (int i = 0; i < adj.get(current).size(); i++) {
				Pair temp = adj.get(current).get(i);
				int node = temp.first;
				int weight = temp.weight;

				// Only update the weight if the new weight (current node + weight) < weight of
				// adj;
				if (sortestPath[current] + weight < sortestPath[node]) {
					sortestPath[node] = sortestPath[current] + weight;
				}
			}

		}
		for (int i : sortestPath) {
			System.out.print(i + ", ");
		}

	}
	// [3, 2, 1, 5, 4, 0]

	private static void topoSort(List<List<Pair>> adj, Stack<Integer> stack, int[] visited, int node) {
		visited[node] = 1;
		for (int i = 0; i < adj.get(node).size(); i++) {
			int secondNode = adj.get(node).get(i).first;
			if (visited[secondNode] == 0) {
				topoSort(adj, stack, visited, secondNode);
			}
		}
		stack.add(node);
	}

}
