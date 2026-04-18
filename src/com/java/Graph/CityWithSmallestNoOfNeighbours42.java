package com.java.Graph;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
public class CityWithSmallestNoOfNeighbours42 {

	public static void main(String[] args) {
//		int v = 4;
//		int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
//		int distanceThreshold = 4;

		// use case 2:
		int v = 5;
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;

		int n = v;
		int m = v;

		int[][] distance = new int[n][m];

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j)
					distance[i][j] = 0;
				else
					distance[i][j] = (int) 1e9;
			}
		}

		for (int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			int weight = edges[i][2];

			distance[start][end] = weight;
			distance[end][start] = weight;
		}

		for (int via = 0; via < n; via++) {
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
				}
			}
		}

		// now calculate row wise (vertex) to find the non 0 distance less than
		// threshold
		for (int[] temp : distance) {
			for (int i : temp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		int count = Integer.MAX_VALUE;
		int mincity = -1;
		for (int vertex = 0; vertex < v; vertex++) {
			int rowmax = 0;
			for (int i = 0; i < v; i++) {
				if (i != vertex) {
					if (distance[vertex][i] <= distanceThreshold) {
						rowmax++;
					}
				}
			}
			count = Math.min(rowmax, count);// here we need to capture that particular city also
			// when updating the count so
			if (rowmax <= count) {
				count = rowmax;
				mincity = vertex;
			}

		}

		System.out.println(mincity);

	}

}
