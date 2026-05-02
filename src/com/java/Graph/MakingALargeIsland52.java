package com.java.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/making-a-large-island/description/
public class MakingALargeIsland52 {

	static class DisjoinSet {
		List<Integer> parent = new ArrayList<>();
		List<Integer> size = new ArrayList<>();

		public DisjoinSet(int n) {
			for (int i = 0; i < n; i++) {
				parent.add(i);
				size.add(1);
			}
		}

		public int findParent(int node) {
			if (parent.get(node) == node) {
				return node;
			}
			int ultParent = findParent(parent.get(node));
			parent.set(node, ultParent);
			return ultParent;
		}

		public void unionBySize(int u, int v) {
			int pu = findParent(u);
			int pv = findParent(v);

			if (pu != pv) {
				if (size.get(pu) > size.get(pv)) {
					parent.set(pv, pu);
					size.set(pu, size.get(pu) + size.get(pv));
				} else {
					parent.set(pu, pv);
					size.set(pv, size.get(pv) + size.get(pu));
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0 }, { 0, 1 } };

		// Task 1 is to create the disjoin set by set to connect and know the size of
		// islands in a grid:
		int n = grid.length;
		int m = grid[0].length;

		DisjoinSet ds = new DisjoinSet(n * m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0)
					continue;
				int drow[] = { -1, 0, 1, 0 };
				int dcol[] = { 0, -1, 0, 1 };
				for (int k = 0; k < 4; k++) {
					int newRow = drow[k] + i;
					int newCol = dcol[k] + j;
					if (isVAlid(newRow, newCol, n, m) && grid[newRow][newCol] == 1) {
						int nodeno = i * n + j;
						int adjNode = newRow * m + newCol;
						ds.unionBySize(nodeno, adjNode);
					}
				}

			}
		}

		// Node for all the 0, try to convert 0 -> 1 and iterate neighbors for land and
		// add them
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Set<Integer> nodeComponent = new HashSet<>();
				if (grid[i][j] == 1)
					continue;
				int drow[] = { -1, 0, 1, 0 };
				int dcol[] = { 0, -1, 0, 1 };
				for (int k = 0; k < 4; k++) {
					int newRow = drow[k] + i;
					int newCol = dcol[k] + j;
					if (isVAlid(newRow, newCol, n, m)) {
						if (grid[newRow][newCol] == 1) {
							// to avoid duplicates add parent into the component res;
							int parent = ds.findParent(newRow * m + newCol);
							nodeComponent.add(parent);
						}
					}
				}
				// now once all the tile of one island is visited find the size of this island:
				// we know that size array has the size of island by it's parent
				int totalSize = 1;
				for (Integer tile : nodeComponent) {
					totalSize += ds.size.get(tile);
				}
				max = Math.max(max, totalSize);
			}
		}

		// edge case where all the cells are 1 :
		// In that case we will have to traverse all the land again and give the
		// ultimate parent size
		for (int i = 0; i < n * m; i++) {
			max = Math.max(max, ds.size.get(ds.findParent(i)));
		}
		
		System.out.println(max);

	}

	private static boolean isVAlid(int row, int col, int n, int m) {

		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
