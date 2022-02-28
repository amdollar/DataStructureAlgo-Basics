package com.java.Tries;

public class TriesDriver {

	public static void main(String[] args) {
		String[] words = new String[] { "Anurag", "Anu", "King", "Banana", "Bana" };
		String[] queries = new String[] { "Anurag", "An", "King", "Ba", "Banan" };
		Tries tries = new Tries();
		for (String word : words) {
			tries.push(word);
		}
		for (String temp : queries) {
			System.out.println(tries.search(temp));
		}

	}

}
