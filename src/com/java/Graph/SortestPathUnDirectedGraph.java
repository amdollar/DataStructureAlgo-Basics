package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class SortestPathUnDirectedGraph {
	public static void main(String[] args) {
		int e = 10;
		int V = 9;
		int source = 0;

		int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 3, 4 }, { 4, 5 }, { 2, 6 }, { 5, 6 }, { 6, 7 }, { 6, 8 },
				{ 7, 8 } };

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			adj.add(new ArrayList<>()); 
		}

		for (int i = 0; i < e; i++) {

			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		int[] dis = new int[e];
		for (int i = 0; i < e; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[source] = 0;

		// we need to perform the bfs on this graph, we need to use the queue fo this
		// purpose:

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int neighbour : adj.get(curr)) {
				if (dis[curr] + 1 < dis[neighbour]) {
					dis[neighbour] = dis[curr] + 1;
					queue.add(neighbour);
				}

			}
		}
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				dis[i] = -1;
			}
		}

		for (int i : dis) {
			System.out.println(i);
		}
	}

}
