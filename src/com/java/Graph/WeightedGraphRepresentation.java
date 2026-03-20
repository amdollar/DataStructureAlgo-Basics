package com.java.Graph;

import java.util.ArrayList;
import java.util.List;

class Pair{
	int nodew, weight;
	Pair(int nodew, int weight){
		this.nodew = nodew;
		this.weight = weight;
	}
}

public class WeightedGraphRepresentation {

	public static void main(String[] args) {
		List<List<Pair>> graph = new ArrayList<>();
		int nodes = 3, edges = 3;
		
		for(int i = 0; i <= nodes; i++) {
			graph.add(new ArrayList());
		}
		
		// 1-> 2 (3)
		// 2 ->1 (3)
		graph.get(1).add(new Pair(2, 3));
		graph.get(2).add(new Pair(1, 3));
		
		// 2-> 3 (4)
		graph.get(2).add(new Pair(3, 4));
		
		
		// Printing the whole graph in List format:
		for(int i = 1; i< nodes; i++) {
			for(int j = 0; j< graph.get(i).size(); j++) {
				Pair pair = graph.get(i).get(j);
				System.out.print(pair.nodew +" , "+ pair.weight);
			}
			System.out.println();
		}

	}

}
