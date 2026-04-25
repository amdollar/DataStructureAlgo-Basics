package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet46 {

	static class DisjointSet {
		List<Integer> rank = new ArrayList<>();
		List<Integer> parents = new ArrayList<>();

		DisjointSet(int n) {
			for (int i = 0; i <= n; i++) {
				// Rank of all the nodes int the beginning will be 0
				rank.add(0);
				// Parent of all the nodes in the beginning will be self
				parents.add(i);
			}
		}

		// Method to find the findUParent

		public int findUParent(int node) {
			if (parents.get(node) == node) {
				return node;
			}
			int ultparent = findUParent(parents.get(node));
			parents.set(node, ultparent);
			return ultparent;
		}

		public void unionByRank(int u, int v) {
			int ultpu = findUParent(u);
			int ultpv = findUParent(v);

			if (ultpu == ultpv)
				return;

			// There 3 cases will be there
			// rank(u) < rank(v) u will get added to v
			// rank(u) > rank(v) v will get added to u
			// rank(u) == rank(v) anyone can be added to anyone

			if (rank.get(ultpu) < rank.get(ultpv)) {
				parents.set(ultpu, ultpv);
			} else if (rank.get(ultpu) < rank.get(ultpv)) {
				parents.set(ultpu, ultpv);
			} else {
				parents.set(ultpu, ultpv);
				rank.set(ultpu, rank.get(ultpu) + 1);
			}

		}
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);

		// if 3 and 7 belong to the same group
		if (ds.findUParent(3) == ds.findUParent(7)) {
			System.out.println("They belong to same set");
		} else {
			System.out.println("They do not belong to same set");
		}
		// after creating the link b/w 2 disjoint graphs:
		ds.unionByRank(3, 7);

		if (ds.findUParent(3) == ds.findUParent(7)) {
			System.out.println("They belong to same set");
		} else {
			System.out.println("They do not belong to same set");
		}
	}

}
