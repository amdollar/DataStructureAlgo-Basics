package com.java.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		// create a graph
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> adj = new ArrayList<>();

		int vertex = sc.nextInt();
		int edges = sc.nextInt();

		for (int i = 0; i <= vertex; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i<= edges; i++) {
			// inputs will be vertex and we need to define edges b/w them
			int v = sc.nextInt();
			int u = sc.nextInt();
			
			adj.get(v).add(u);
			adj.get(u).add(v);
			
			
		}
		printGraph(adj, vertex, edges);
		// call method for DFS
		
		dfs(adj, vertex, edges);

	}

	private static void dfs(List<List<Integer>> adj, int vertex, int edges) {
		System.out.println("Prinitng DFS for given graph");
		
	}

	private static void printGraph(List<List<Integer>> adj, int vertex, int edges) {
		for(int i = 0; i<= vertex; i++) {
			for (int j= 0; j< adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}

}
