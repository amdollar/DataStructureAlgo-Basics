package com.java.RecursionChapter2;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/dsa/permute-string-changing-case/
public class PermutationWithCaseChange {

	public static void main(String[] args) {
		String input = "ab";

		List<String> res = new ArrayList<>();

		String output = "";

		getPermutedStringChangingCases(input, output, res);
		for (String temp : res) {
			System.out.println(temp);
		}

	}

	private static void getPermutedStringChangingCases(String input, String output, List<String> res) {

		if (input.length() == 0) {
			res.add(output);
			return;
		}

		String output1 = output;
		String output2 = output;

		output1 = output + input.charAt(0);
		output2 = output + Character.toUpperCase(input.charAt(0));
		input = input.substring(1);

		getPermutedStringChangingCases(input, output1, res);
		getPermutedStringChangingCases(input, output2, res);
	}

}
