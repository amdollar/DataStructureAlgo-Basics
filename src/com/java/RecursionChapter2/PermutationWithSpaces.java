package com.java.RecursionChapter2;

// https://www.geeksforgeeks.org/problems/permutation-with-spaces3627/1
import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpaces {

	public static void main(String[] args) {
		String input = "ABC";

		List<String> ans = new ArrayList<>();

		String output = input.substring(0, 1);
		input = input.substring(1);
		System.out.println(output + " " + input);
		generateStringsWithSpaces(input, output, ans);

		for (String temp : ans) {
			System.out.println(temp);
		}
	}

	private static void generateStringsWithSpaces(String input, String output, List<String> ans) {
		if (input.length() == 0) {
			ans.add(output);
			return;
		}

		// I have two choices now either add the gap or not add the gap:
		String output1 = output;
		String output2 = output;

		output1 = output + "_" + input.charAt(0);
		output2 = output + input.charAt(0);

		input = input.substring(1);

		generateStringsWithSpaces(input, output1, ans);
		generateStringsWithSpaces(input, output2, ans);
	}

}
