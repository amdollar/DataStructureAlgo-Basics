package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphRepresentation {

	public static void main(String[] args) {
		// Define the total number of edges and vertex
		int n = 3, m = 3;
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 1->2
		// 2->1
		graph.get(1).add(2);
		graph.get(2).add(1);

		// 2->3
		// 3->2
		graph.get(2).add(3);
		graph.get(3).add(2);

		for (int i = 1; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j)+ " ");
			}
			System.out.println();
		}

	}

}

