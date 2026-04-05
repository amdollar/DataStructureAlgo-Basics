package com.java.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/description/
public class WordLadderI {

	static class Pair {
		String word;
		int pos;

		Pair(String word, int pos) {
			this.word = word;
			this.pos = pos;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		Set<String> words = new HashSet<>();

		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		for (String word : wordList) {
			words.add(word);
			System.out.println(word);
		}

		Queue<Pair> tracker = new LinkedList<>();

		tracker.offer(new Pair(beginWord, 1));

		while (!tracker.isEmpty()) {
			Pair curr = tracker.poll();
			String curWord = curr.word;// hit
			int pos = curr.pos;
			
			if(curWord.equals(endWord)) 
				System.out.println(pos);

			for (int i = 0; i < beginWord.length(); i++) {
				for (char ch = 'a'; ch < 'z'; ch++) {
					char[] curarr = curWord.toCharArray();
					curarr[i] = ch;
					String newWord = new String(curarr);
					if (words.contains(newWord)) {
						words.remove(newWord);
						tracker.offer(new Pair(newWord, pos + 1));
					}
				}

			}
		}

	}

}
