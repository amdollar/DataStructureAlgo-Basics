package com.java.Tries;

import java.util.HashSet;
import java.util.Set;

public class TriesDriver {

	public static void main(String[] args) {
		// It takes O(N * L) to build the ties. [ ignored the word length]
		String[] words = new String[] { "Anurag", "Anu", "King", "Banana", "Bana" };
		// Query time is : O(L)
		String[] queries = new String[] { "Anurag", "An", "King", "Ba", "Banan" };
		Set<String> set = new HashSet<>();
		Tries tries = new Tries();
		for (String word : words) {
			tries.push(word);
		}
		for (String temp : queries) {
			System.out.println(tries.search(temp));
		}

	}

}
