package com.java.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Dictionary order is given in words, but words order is unknows, 
// by reading the Dictionary order we need to find out the word order.
// N -> Words | K -> Starting alphabets
public class AlienDictionary {

	public static void main(String[] args) {

		String words[] = { "baa", "abcd", "abca", "cab", "cad" };
		int N = words.length;
		int K = 4;

		// Create a graph for the chars that are having difference:
		// baa : abcd -- ? b -> a
		// abcd : abca -- ? d -> a

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < K; i++) {
			String str1 = words[i];
			String str2 = words[i + 1];

			int len = Math.min(str1.length(), str2.length());
			for (int j = 0; j < len; j++) {
				if (str1.charAt(j) != str2.charAt(j)) {
					adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
					break;
				}
			}

		}

		// Graph representation of the Unique chars
		for (int i = 0; i < K; i++) {
			System.out.print(i + " ->");
			for (int node : adj.get(i)) {
				System.out.print(node + " ");
			}
			System.out.println();
		}

		// now we have nodes in the graphs we can apply our Topological sorting here:
		// 1. create the in-degree array:
		int[] indegree = new int[K];
		for (int i = 0; i < K; i++) {
			for (int neighbour : adj.get(i)) {
				indegree[neighbour]++;
			}
		}
		// 2. Start with the nodes that have in-degree as 0 and then keep on repeating
		// with their neighbors:
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		// 3. Perform topological sorting:
		List<Integer> ansls = new ArrayList<>();
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			ansls.add(curr);

			for (int nei : adj.get(curr)) {
				// reduce the in-degree for the neighbor node:
				indegree[nei]--;
				// if now the in-degree is 0 add it to the queue for further processing
				if (indegree[nei] == 0) {
					queue.offer(nei);
				}
			}
		}

		String ans = new String();
		for (int i : ansls) {
			ans = ans + (char) (i + (int) ('a'));
		}
		System.out.println(ans);
	}

}
