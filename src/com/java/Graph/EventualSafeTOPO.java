package com.java.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeTOPO {

	public static void main(String[] args) {
		int[][] adj = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		int n = adj.length;

		// 1-2
		// 2-3

		// 2-1[[1, 2], [2, 3], [5], [0], [5], [], []]
//				[[3], [0], [0, 1], [1], [], [2, 4], []]
		// [[3], [0], [0, 1], [1], [], [2, 4], []]
		// 3-2
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// Reversed in-degree in a adj graph:
		int[] indeg = new int[n];

		for (int i = 0; i < n; i++) {
			for (int temp : adj[i]) {
				graph.get(temp).add(i);
				indeg[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indeg[i] == 0) {
				queue.offer(i);
			}
		}

		// Start processing with topological sorting:
		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			res.add(curr);

			for (int temp : graph.get(curr)) {
				indeg[temp]--;
				if (indeg[temp] == 0) {
					queue.add(temp);
				}
			}

		}

		Collections.sort(res);
		for (int i : res) {
			System.out.print(i + " , ");
		}
		System.out.println("");
	}

}
