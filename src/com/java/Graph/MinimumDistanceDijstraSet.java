package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MinimumDistanceDijstraSet {

	static class Node {
		int target;
		int distance;

		Node(int target, int distance) {
			this.target = target;
			this.distance = distance;
		}

	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 4 }, { 0, 2, 4 }, { 1, 2, 2 }, { 2, 3, 3 }, { 2, 4, 1 }, { 2, 5, 6 }, { 3, 5, 2 },
				{ 4, 5, 3 } };
		int V = 6;
		int E = edges.length;
		
		int source = 0;

		// Implement dijkstra using Set data structure instead of Priority Queue;

		// Create adj representation of the Graph:
		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int first = edges[i][0];
			int target = edges[i][1];
			int distance = edges[i][2];

			adj.get(first).add(new Node(target, distance));
		}

		// Create a distance result array to capture the distance:
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		// Create Set and start filling the values for further processing
		TreeSet<Node> st = new TreeSet<Node>((a, b) -> (a.distance == b.distance) ? a.target - b.target : a.distance - b.distance);
		st.add(new Node(source, 0));

		while (!st.isEmpty()) {
			Node curr = st.pollFirst();
			int cutar = curr.target;
			int cudis = curr.distance;

			for (Node temp : adj.get(cutar)) {
				int temptar = temp.target;
				int tempdis = temp.distance;

				if (cudis + tempdis < distance[temptar]) {
					// Now if the newly calculated distance is less than already existing distance
					// && already existing distance != MaxVal then update it and remove if from set;
					if (distance[temptar] != Integer.MAX_VALUE) {
						st.remove(new Node(temptar, distance[temptar]));
					}
					distance[temptar] = cudis + tempdis; 
					st.add(new Node(temptar, distance[temptar]));

				}

			}
			
		}
		for(int i : distance) {
			System.out.println(i);
		}

		

	}

}
