package com.java.Graph;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFord41 {

	public static void main(String[] args) {
		// task is to compute the shortest distance from source to all other vertices.
		// if the vertex is un-reachable from the source, mark it as 10^8.
		// Additionally if a graph contains a -v cycle, return [-1]
		int v = 5;
		int[][] edges = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
		int src = 0;

		// there will not be any sequence known to us and the distance array is
		// initilized to
		// infinite in the beginning apart from the source,
		// Step 1: Perform edge relaxation for n-1 times.

		// distance array initialized to infinite for each.
		int[] dis = new int[v];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;

		for (int i = 0; i < v - 1; i++) {
			for (int[] edge : edges) {
				int source = edge[0];
				int destination = edge[1];
				int distance = edge[2];

				if (dis[source] != Integer.MAX_VALUE && dis[source] + distance < dis[destination]) {
					dis[destination] = dis[source] + distance;
				}
			}
		}

		// To detect a cycle:
		// If there is a cycle with -v weight, it will reduce the path in every
		// iteration, so we can
		// use this trick for source one, and if the weight is reduced then we know that
		// there is a
		// cycle

		for (int[] edge : edges) {
			int source = edge[0];
			int destination = edge[1];
			int weight = edge[2];

			if (dis[source] != Integer.MAX_VALUE && dis[source] + weight < dis[destination]) {
				int temp[] = new int[1];
				temp[0] = -1;
				System.out.println(temp);
				return;
			}
		}

		for (int i : dis)
			System.out.println(i);
	}

}
