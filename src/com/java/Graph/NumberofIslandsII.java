package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

//https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51
public class NumberofIslandsII {

	static class DisjoinSet {
		ArrayList<Integer> rank = new ArrayList<>();
		ArrayList<Integer> parent = new ArrayList<>();

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

		public void disjoin(int u, int v) {
			int pu = findParent(u);
			int pv = findParent(v);

			if (rank.get(pu) < rank.get(pv)) {
				parent.set(pv, pu);
			} else if (rank.get(pu) > rank.get(pv)) {
				parent.set(pu, pv);
			} else {
				parent.set(pv, pu);
				rank.set(pu, rank.get(pu) + 1);
			}
		}
	}

	public static boolean isValid(int adjr, int adjc, int n, int m) {
		return (adjr >= 0 && adjr < n && adjc >= 0 && adjc < m);

	}

	public static void main(String[] args) {
		int n = 4;
		int m = 5;
		int steps = 4;
		int[][] ops = { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };

		DisjoinSet ds = new DisjoinSet(n * m);

		// have one visited array:
		int[][] island = new int[n][m];
		int[][] visited = new int[n][m];

		List<Integer> ans = new ArrayList<>();
		// now start operation:

		int count = 0;

		for (int i = 0; i < ops.length; i++) {
			int row = ops[i][0];
			int col = ops[i][1];
			int deltarow[] = { -1, 0, 1, 0 };
			int deltacol[] = { 0, 1, 0, -1 };

			if (visited[row][col] == 1) {
				ans.add(count);
				continue;
			}
			visited[row][col] = 1;
			count++;

			for (int k = 0; k < 4; k++) {
				int adjrow = deltarow[k] + row;
				int adjcol = deltacol[k] + col;
				if (isValid(adjrow, adjcol, n, m)) {
					if (visited[adjrow][adjcol] == 1) {
						int nodeNo = row * m + col;
						int adjnodeNode = adjrow * m + adjcol;
						if (ds.findParent(nodeNo) != ds.findParent(adjnodeNode)) {
							count--;
							ds.disjoin(nodeNo, adjnodeNode);
						}
					}
				}
			}
			ans.add(count);
		}

		for (int i : ans) {
			System.out.println(i);
		}
	}
}
