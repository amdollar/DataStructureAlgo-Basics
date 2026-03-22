package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {

		List<List<Integer>> adj = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();
		int edges = sc.nextInt();

		for (int i = 0; i <= vertex; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i <= edges; i++) {
			// take the vertexs as input to define edges b/w two of them
			// 2-3 3-2
			int v = sc.nextInt();
			int u = sc.nextInt();

			adj.get(v).add(u);
			adj.get(u).add(v);
		}
		printGraph(adj, vertex, edges);

		bfs(adj, vertex + 1, 1);

	}

	private static void bfs(List<List<Integer>> graph, int vertex, int startNode) {
		// Queue for BFS and visited array for tracking.
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[vertex];

		// Mark start node as visited and add it in the queue for further processing.
		visited[startNode] = true;
		queue.offer(startNode);
		System.out.println("BFS traversal:");

		// Process the queue while it is not empty
		while (!queue.isEmpty()) {
			// grab the first element of the queue
			int current = queue.poll();
			System.out.print(current + " ");

			// Grab the adj list attached to this node in adj graph
			for (int element : graph.get(current)) {
				if (!visited[element]) {
					visited[element] = true;
					queue.add(element);
				}
			}

		}

	}

	private static void printGraph(List<List<Integer>> graph, int v, int e) {
		for (int i = 0; i <= v; i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
