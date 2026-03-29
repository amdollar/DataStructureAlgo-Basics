package com.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

//A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 
// if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

public class NoOfProvinces {

	public static void main(String[] args) {
		int count = 0;

//		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int vertex = isConnected.length;
		int edges = isConnected[1].length;

		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				System.out.print(isConnected[i][j] + " ");
			}
			System.out.println("");
		}

		boolean visited[] = new boolean[vertex];

		// simple logic is: Have total vertex, and count how many calls we are making to
		// traverse the given graph.
		// for each province we will have to make a call.

		for (int i = 0; i < vertex; i++) {
			if (!visited[i]) {
				count++;
				bfs(i, isConnected, visited);
			}
		}

		System.out.println("Number of Provinces: " + count);
	}

	private static void bfs(int vertex, int[][] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();

			// visit all the cols for this one row:
			for (int j = 0; j < graph.length; j++) {
				if (graph[current][j] == 1 & !visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}

	}

}
