package com.java.RecursionChapter2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/description/
public class LetterCasePermutation {

	public static void main(String[] args) {
		String input = "a1b2";
		List<String> ans = new ArrayList<>();
		String output = "";

		generateLetterCasePermutations(input, output, ans);

		for (String temp : ans) {
			System.out.println(temp);
		}

	}

	private static void generateLetterCasePermutations(String input, String output, List<String> res) {
		if (input.length() == 0) {
			res.add(output);
			return;
		}

		String output1 = output;
		String output2 = output;

		char curr = input.charAt(0);
		if (Character.isAlphabetic(curr)) {
			if (Character.isUpperCase(curr)) {
				curr = Character.toLowerCase(curr);
			} else {
				curr = Character.toUpperCase(curr);
			}
			output1 = output + input.charAt(0);
			output2 = output + curr;
			input = input.substring(1);
			generateLetterCasePermutations(input, output1, res);
			generateLetterCasePermutations(input, output2, res);
		} else {
			output1 = output + input.charAt(0);
			input = input.substring(1);
			generateLetterCasePermutations(input, output1, res);
		}

	}

}
