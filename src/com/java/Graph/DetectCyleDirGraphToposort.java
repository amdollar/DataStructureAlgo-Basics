package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCyleDirGraphToposort {

	public static void main(String[] args) {
		int V = 6;

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(2).add(3);
		adj.get(3).add(1);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(5).add(0);
		adj.get(5).add(2);

		// 0. have a in-degree array for each node:
		int[] inde = new int[V];
		for (int i = 0; i < V; i++) {
			for (int node : adj.get(i)) {
				inde[node]++;
			}
		}

		// 1. start with a queue having elements with 0 degree.
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (inde[i] == 0)
				queue.offer(i);
		}
		int count = 0;

		while (!queue.isEmpty()) {

			int node = queue.poll();
			count++;

			// this loop will end when there is no ADJ node to the popped node:
			for (int adjNode : adj.get(node)) {
				inde[adjNode]--;
				// only add this node into the Queue when the In_degree of node is 0
				if (inde[adjNode] == 0) {
					queue.offer(adjNode);
				}
			}
		}
		if (count != V)
			System.out.println("There is a cycle in the graph");
		else
			System.out.println("There is no cycle in the graph");
	}

}
