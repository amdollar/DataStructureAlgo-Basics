package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1
//Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive cells along that path
public class PathWithMinimumEfforts37 {

	static class Node {
		int difference;
		int row;
		int col;

		Node(int difference, int row, int col) {
			this.difference = difference;
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) {
		int[][] mat = { { 7, 2, 6, 5 }, { 3, 1, 10, 8 } };

		int n = mat.length;
		int m = mat[0].length;

		// It's a problem that involves Source to Destination Path we can use Dijkstra
		// here
		// Main components of dijs are: PQ and Visited array:

		int[][] dist = new int[n][m];

		for (int[] temp : dist) {
			Arrays.fill(temp, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;

		// Need to store the data in PQ sorted by difference (Minimum first- Minimum
		// Heap)

		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.difference - b.difference);

		// add first node from the grid i.e. source:
		pq.offer(new Node(0, 0, 0));

		int[] deltarow = { -1, 0, 1, 0 };
		int[] deltacol = { 0, 1, 0, -1 };

		while (!pq.isEmpty()) {
			Node curr_node = pq.poll();

			int curr_dif = curr_node.difference;
			int curr_row = curr_node.row;
			int curr_col = curr_node.col;

			if (curr_row == n - 1 && curr_col == m - 1) {
				System.out.println(curr_dif);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int new_row = curr_row + deltarow[i];
				int new_col = curr_col + deltacol[i];
				if (new_row >= 0 && new_row < n && new_col >= 0 && new_col < m) {
					int new_dis = Math.max(curr_dif, Math.abs(mat[curr_row][curr_col] - mat[new_row][new_col]));
					if (new_dis < dist[new_row][new_col]) {
						dist[new_row][new_col] = new_dis;
						pq.add(new Node(new_dis, new_row, new_col));
					}
				}
			}

		}
		System.out.println("here");

	}

}
