package com.java.Recursion;

/*
for given strings we need to generated all the permutations of strings having spaces in between
we cant have spaces at 0th and last index of the string*/
public class PermutationsWithSpaces {

	public static void main(String[] args) {
		String input = new String("ABCDEF");
		String output = String.valueOf(input.charAt(0));
		input = input.substring(1, input.length());
		// we need to consider first char as a initialized output
		// after that we can draw recursion tree with remaining inputs.
		generatePermutations(input, output);
	}

	private static void generatePermutations(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String output1 = output;
		String output2 = output;
		output1 = output + "_" + input.charAt(0);
		output2 = output + input.charAt(0);
		input = removeCharAt(input, 0);
		generatePermutations(input, output1);
		generatePermutations(input, output2);
	}

	private static String removeCharAt(String input, int indes) {
		StringBuffer sb = new StringBuffer(input);
		sb.deleteCharAt(0);
		return new String(sb);

	}

}
