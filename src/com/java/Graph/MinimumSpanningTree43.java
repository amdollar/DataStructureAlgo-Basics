package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

/*
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights
 of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is provided as a list of edges, where each edge is 
 represented as [u, v, w], indicating an edge between vertex u and vertex v with edge weight w.*/

public class MinimumSpanningTree43 {

	// We will use Prim's algorithm
	static class Tuple {
		int weight;
		int end;
		int parent;

		Tuple(int weight, int end, int parent) {
			this.weight = weight;
			this.end = end;
			this.parent = parent;
		}
	}

	static class Node {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
//
//		int V = 3;
//		int E = 3;
//		int[][] Edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

		// case 2:
		int V = 2;
		int E = 1;
		int[][] Edges = { { 0, 1, 5 } };


		// we would need one visited array:
		int[] vis = new int[V];

		// For tracking of adjacent nodes:
		List<List<Node>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int u = Edges[i][0];
			int v = Edges[i][1];
			int w = Edges[i][2];

			adj.get(u).add(new Node(v, w));
			adj.get(v).add(new Node(u, w));
		}

		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a, b) -> a.weight - b.weight);
		pq.offer(new Tuple(0, 0, -1));

		int totalMstSum = 0;

		while (!pq.isEmpty()) {
			Tuple current = pq.poll();
			int end = current.end;
			int weight = current.weight;
			int parent = current.parent;
			if (vis[end] == 1)
				continue;
			vis[end] = 1;
			totalMstSum += weight;

			for (Node nei : adj.get(end)) {
				if (vis[nei.end] == 0) {
					pq.offer(new Tuple(nei.weight, nei.end, end));

				}

			}

		}
		System.out.println("MST sum: " + totalMstSum);
	}

}
