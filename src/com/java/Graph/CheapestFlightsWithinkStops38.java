package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.print.attribute.standard.Destination;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

public class CheapestFlightsWithinkStops38 {

	static class Tuple {
		int step;
		int node;
		int fare;

		Tuple(int step, int node, int fare) {
			this.step = step;
			this.node = node;
			this.fare = fare;
		}
	}

	static class Node {
		int end;
		int fare;

		Node(int end, int fare) {
			this.end = end;
			this.fare = fare;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };

		int src = 0;
		int dst = 3;
		int k = 1;

		// create a adj list for better processing of the flight-data;

		List<List<Node>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		// This is a single directional Graph city A -> city B

		for (int[] flight : flights) {
			adj.get(flight[0]).add(new Node(flight[1], flight[2]));
		}

		// Create the fares array: and keep on filling the data in it
		// we will in the end return the destination's value,
		//
		int[] fares = new int[n];
		Arrays.fill(fares, Integer.MAX_VALUE);
		// Mark source as 0
		fares[src] = 0;

		// Use a priority queue to process the nodes:
//		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a, b) -> a.step - b.step);

		// we can use simple queue here anyhow, the data is stored in increasing order
		// of steps only:
		Queue<Tuple> pq = new LinkedList<>();
		pq.offer(new Tuple(0, 0, 0));

		while (!pq.isEmpty()) {
			Tuple current = pq.poll();
			int curStep = current.step;
			int curnode = current.node;
			int curFare = current.fare;

//			if (curnode == dst) {
//				System.out.println("Total fair to reach is: " + curFare + " , total steps: " + curStep);
//				return;
//			}
			if (curStep > k)
				continue;

			for (Node neighbour : adj.get(curnode)) {
				int neightbourNode = neighbour.end;
				int neighbourFare = neighbour.fare;

				if (curFare + neighbourFare < fares[neightbourNode] && curStep <= k) {
					fares[neightbourNode] = curFare + neighbourFare;
					pq.offer(new Tuple(curStep + 1, neightbourNode, curFare + neighbourFare));
				}

			}

		}
		if (fares[dst] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(fares[dst]);
		}

	}

}
