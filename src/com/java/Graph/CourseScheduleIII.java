package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/prerequisite-tasks/1 
// https://leetcode.com/problems/course-schedule/

// Basically we need to find if there is a cyclic dependency b/w the tasks
// We need to find the cycle in this. 
// We can use Kahn's algorithm to detect that.

public class CourseScheduleIII {

	public static void main(String[] args) {
		int N = 4;
		int[][] prequisities = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
//		int[][] prequisities = { { 1, 0 }, { 0, 1 } };

		int n = prequisities.length;

		// Adj List representation of the graph;
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		// Add elements from the grid to graph;
//		for (int i = 0; i < n; i++) {
//			for (int temp : prequisities[i]) {
//				graph.get(i).add(temp);
//			}
//		}

		for (int i = 0; i < n; i++) {
			graph.get(prequisities[i][1]).add(prequisities[i][0]);
		}

		// Create a in-degree array to capture in-degree of each node
		int[] indegree = new int[N];
		for (int i = 0; i < N; i++) {
			for (int node : graph.get(i)) {
				indegree[node]++;
			}
		}

		// Queue to capture the node with 0 nodes and then add them in res after
		// processing:
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		// Process with BFS
		int count = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			count++;
			

			for (int adj : graph.get(temp)) {
				indegree[adj]--;
				if (indegree[adj] == 0) {
					queue.add(adj);
				}
			}

		}
		if (count == N)
			System.out.println("Can be done");
		else
			System.out.println("Cant be done");

	}

}
