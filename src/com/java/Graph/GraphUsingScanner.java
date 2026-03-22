package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphUsingScanner {

	public static void main(String[] args) {

		List<List<Integer>> adj = new ArrayList<>();
		System.out.println("Started..");
		Scanner sc = new Scanner(System.in);
		// Take input of no of vertex and edges
		int vertex = sc.nextInt();
		int edges = sc.nextInt();

		// Create the empty Adj List with number of edges to hold the internal connected
		// nodes
		for (int i = 0; i <= vertex; i++) {
			adj.add(new ArrayList());
		}

		// Take input for read each edge input (Vertex and then Edge)
		for (int i = 0; i <= edges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			//Adding edge to adj list:
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		// Print graph
		printGraph(adj, vertex, edges);

	}

	private static void printGraph(List<List<Integer>> adj, int v, int e) {
		for(int i= 1; i<= v; i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
