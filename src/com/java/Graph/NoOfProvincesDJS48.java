package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvincesDJS48 {

	static class DisJointSet {
		List<Integer> rank = new ArrayList<>();
		List<Integer> parent = new ArrayList<>();

		DisJointSet(int n) {
			for (int i = 0; i < n; i++) {
				rank.add(0);
				parent.add(i);
			}
		}

		int findParent(int node) {
			if (parent.get(node) == node) {
				return node;
			}
			int ultParent = findParent(parent.get(node));
			parent.set(node, ultParent);
			return ultParent;
		}

		public void union(int u, int v) {
			int pu = findParent(u);
			int pv = findParent(v);

			int rpu = rank.get(pu);
			int rpv = rank.get(pv);

			if (rpu < rpv) {
				parent.set(rpu, rpv);
			} else if (rpu > rpv) {
				parent.set(pv, pu);
			} else {
				parent.set(pv, pu);
				rank.set(rpu, rank.get(pu) + 1);
			}

		}

		public int findProvinces() {
			int count = 0;
			for (int i = 0; i < parent.size(); i++) {
				if (i == parent.get(i)) {
					count++;
				}
			}
			return count;
		}

	}

	public static void main(String[] args) {
//		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		DisJointSet ds = new DisJointSet(isConnected[0].length);

		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					ds.union(i, j);
				}
			}
		}

		int ans = ds.findProvinces();
		System.out.println(ans);

	}

}
