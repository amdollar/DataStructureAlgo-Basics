package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumDistanceDijkstraAlgo {
	static class Pair {

		int node;
		int distance;

		Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		int source = 0;
		int n = 6;

		int[][] edges = { { 0, 1, 4 }, { 0, 2, 4 }, { 1, 2, 2 }, { 2, 3, 3 }, { 2, 4, 1 }, { 2, 5, 6 }, { 3, 5, 2 },
				{ 4, 5, 3 } };

		List<List<Pair>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int tar = edges[i][1];
			int dis = edges[i][2];
			Pair curr = new Pair(tar, dis);
			adj.get(src).add(curr);
		}

		// Init the distance arr with Infinite values for each node.
		int[] distance = new int[n];
		for (int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		// keep the source node distance from itself as 0
		distance[source] = 0;

		// Create a Priority Queue to track the nodes and progress:
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

		pq.offer(new Pair(source, 0));

		while (!pq.isEmpty()) {
			Pair curr = pq.poll();
			int tnode = curr.node;
			int tdistance = curr.distance;

			for (Pair temp : adj.get(tnode)) {
				int adjdis = temp.distance;
				int adjnode = temp.node;

				if (tdistance + adjdis < distance[adjnode]) {
					distance[adjnode] = tdistance + adjdis;
					pq.offer(new Pair(adjnode, distance[adjnode]));
				}
			}
		}
		for (int i : distance) {
			System.out.println(i);
		}

	}

}
