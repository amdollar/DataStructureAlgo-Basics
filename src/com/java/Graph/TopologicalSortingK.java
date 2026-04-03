package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingK {

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

		// 1 we will use khan's algo here as per that we need to :
		// i. first calculate the in-degree of all the vertices.
		// ii. since in-degree == 0 can be kept first in the order so we can start DFS
		// from there and keep on removing the in-degrees for it's adj nodes.
		// iii. Once the in-degree of particular node is 0 we can put that in the
		// result.

		// Create the in-degree array: Inside that we need to put number of in-nodes to
		// each vertex from graph:

		int[] indegree = new int[adj.size()];

		for (int i = 0; i < indegree.length; i++) {
			for (int temp : adj.get(i)) {
				indegree[temp]++;
			}
		}

		// Put all the Nodes that have in-degree == 0 in the queue, to start our
		// iteration with:
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		int index = 0;
		int[] ans = new int[V];

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			ans[index++] = curr;

			for (int neighbour : adj.get(curr)) {
				indegree[neighbour]--;

				if (indegree[neighbour] == 0) {
					queue.add(neighbour);
				}
			}

		}
		for (int i = 0; i < V; i++) {
			System.out.println(ans[i]);
		}

	}

}
