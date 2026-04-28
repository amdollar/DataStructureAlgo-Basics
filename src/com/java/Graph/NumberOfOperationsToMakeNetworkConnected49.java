package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

public class NumberOfOperationsToMakeNetworkConnected49 {

	static class DisjoinSet {
		List<Integer> rank = new ArrayList<>();
		List<Integer> parent = new ArrayList<>();

		public DisjoinSet(int n) {
			for (int i = 0; i < n; i++) {
				rank.add(0);
				parent.add(i);
			}
		}

		public int findParent(int node) {
			if (parent.get(node) == node) {
				return node;
			}
			int ultimateParent = findParent(parent.get(node));
			parent.set(node, ultimateParent);
			return ultimateParent;
		}

		public void union(int u, int v) {

			int pu = findParent(u);
			int pv = findParent(v);

			if (rank.get(pu) < rank.get(pv)) {
				parent.set(pu, pv);
			} else if (rank.get(pu) > rank.get(pv)) {
				parent.set(pv, pu);
			} else {
				parent.set(pv, pu);
				rank.set(pu, rank.get(pu) + 1);
			}
		}

		int totaldisconnected = 0;

		public int totalDisconnectedNetworks() {

			for (int i = 0; i < parent.size(); i++) {
				if (parent.get(i) == i) {
					totaldisconnected++;
				}
			}

			return totaldisconnected;
		}

	}

	public static void main(String[] args) {
//		int n = 4;
//		int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };

		// case 2:
		int n = 9;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };

		DisjoinSet ds = new DisjoinSet(n);

		int extraEdges = 0;

		if (connections.length < n - 1) {
			System.out.println("-1");
			return;
		}

		for (int i = 0; i < connections.length; i++) {

			if (ds.findParent(connections[i][0]) == ds.findParent(connections[i][1])) {
				extraEdges++;
			} else {
				ds.union(connections[i][0], connections[i][1]);
			}
		}

		// we need to know total number of disconnected components
		// no of provinces

		int totaldisconnected = ds.totalDisconnectedNetworks();

		System.out.println("Total edges required: " + (totaldisconnected - 1));

	}

}
