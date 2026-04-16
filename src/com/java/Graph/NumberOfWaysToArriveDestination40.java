package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
public class NumberOfWaysToArriveDestination40 {

	static class Node {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {

		int n = 7; // number of cities
//		int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
//				{ 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
		
		int [][] roads = {{ 1,0,10}};

		int source = 0;
		int destination = n - 1;

		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i <=  n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] edge : roads) {
			adj.get(edge[0]).add(new Node(edge[1], edge[2]));
			adj.get(edge[1]).add(new Node(edge[0], edge[2]));
		}

		long dis[] = new long[n];
		int path[] = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[source] = 0;
		Arrays.fill(path, 0);
		path[0] = 1;

		// We can use a Priority queue here, that will poll the item with least distance

		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);
		pq.offer(new Node(0, 0));

		// question says to use module we can include here:
		int mod = (int) (1e9 + 7);

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int end = current.end;
			int weight = current.weight;

			for (Node temp : adj.get(end)) {
				int tempend = temp.end;
				int tempweight = temp.weight;
				// first time coming with shorter distance:
				if (weight + tempweight < dis[tempend]) {
					dis[tempend] = weight + tempweight;
					pq.offer(new Node(tempend, weight + tempweight));
					path[tempend] = path[end];
				} // we have arrived to same node via other path but distance is same as already
					// covered (shortest), we need to include that path as well
				else if (weight + tempweight == dis[tempend]) {
					path[tempend] = (path[tempend] + path[end])% mod;
				}

			}
		}
		System.out.println(path[destination] % mod);

	}

}
