package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPath35 {

	static class Node {
		int second;
		int distance;

		Node(int second, int distance) {
			this.second = second;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		int n = 5; // vertices
		int m = 6; // edges

		// Create Adj List representation of this graph:

		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int first = graph[i][0];
			int second = graph[i][1];
			int distance = graph[i][2];
			adj.get(first).add(new Node(second, distance));
			adj.get(second).add(new Node(first, distance));
		}

		// distance and parent array. to track shortest distance and to calculate the
		// final shortest path:
		int dis[] = new int[n + 1];
		int parent[] = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		// start node is 1 so distance should be from 1:
		dis[1] = 0;

		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			int temp_second = temp.second;
			int temp_distance = temp.distance;

			for (Node neighbours : adj.get(temp_second)) {
				int nei_second = neighbours.second;
				int nei_distance = neighbours.distance;
				if (nei_distance + temp_distance < dis[nei_second]) {
					dis[nei_second] = nei_distance + temp_distance;
					pq.offer(new Node(nei_second, nei_distance + temp_distance));
					parent[nei_second] = temp_second;
				}

			}

		}
		List<Integer> path = new ArrayList<>();
		// In case the path is not found then the index of destination will be same as
		// set above (Max Int)
		if (dis[n] == Integer.MAX_VALUE) {
			path.add(-1);
			System.out.println(path);
			return;
		}

		int node = n;
		while (parent[node] != node) {
			path.add(node);
			node = parent[node];
		}
		path.add(1);
		Collections.reverse(path);
		System.out.println(path);

	}

}
