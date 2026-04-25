package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class KrusalAlgoMST47 {

	static class DisjointSet {
		List<Integer> rank = new ArrayList<>();
		List<Integer> parents = new ArrayList<>();
		int u;
		int v;

		int findParent(int node) {

			if (parents.get(node) == node)
				return node;
			int ultparent = findParent(parents.get(node));
			parents.set(node, ultparent);
			return ultparent;
		}

		DisjointSet(int n) {
			for (int i = 0; i <= n; i++) {
				// Rank of all the nodes int the beginning will be 0
				rank.add(0);
				// Parent of all the nodes in the beginning will be self
				parents.add(i);
			}
		}

		public boolean union(int u, int v) {
			// find parent of u and v
			int pu = findParent(u);
			int pv = findParent(v);

			// find ranks of parents
			int rpu = rank.get(pu);
			int rpv = rank.get(pv);

			if (pu == pv) {
				return false;
			}
			if (rpu < rpv) {
				parents.set(pu, pv);
			} else if (rpu > rpv) {
				parents.set(pv, pu);
			} else {
				parents.set(pv, pu);
				rank.set(rpu, rank.get(rpu) + 1);
			}

			return true;
		}

	}

	// we need one List of edges, where Edges are stored in asc sorting order;

	static class Edge implements Comparable<Edge> {

		int src;
		int des;
		int weight;

		Edge(int src, int des, int weight) {
			this.src = src;
			this.des = des;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) {

		int v = 3;
		int e = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } }; // [u, v, w],
		DisjointSet ds = new DisjointSet(v);
		// Shot the input provided to us based on weight element: edges[2]

		for (int i = 0; i < e; i++) {
			for (int j = 0; j < e; j++) {
				System.out.print("" + edges[i][j]);
			}
			System.out.println();
		}

		Arrays.sort((edges), (a, b) -> (Integer.compare(a[2], b[2])));

		for (int i = 0; i < e; i++) {
			for (int j = 0; j < e; j++) {
				System.out.print("" + edges[i][j]);
			}
			System.out.println();
		}

		// Now the edges are sorted in ascending order of weight:
		int mst = 0;

		for (int[] edge : edges) {
			int source = edge[0];
			int des = edge[1];
			int weight = edge[2];

			if (ds.union(source, des)) {
				mst += weight;
			}
		}

		System.out.println(mst);

	}

}
