package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
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

		for (int i = 0; i <= vertex; i++) {
			// take the vertexs as input to define edges b/w two of them
			// 2-3 3-2
			int v = sc.nextInt();
			int u = sc.nextInt();

			adj.get(v).add(u);
			adj.get(u).add(v);
			printGraph(adj, vertex, edges);
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
