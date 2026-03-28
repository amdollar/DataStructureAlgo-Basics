package com.java.Recursion;

public class PrintSubset {

	public static void main(String[] args) {
		String str = new String("abcdefgh");
		String output = new String("");
		printSubSet(str, output);
	}

	private static void printSubSet(String input, String output) {
		// base condition: when input == 0 means reaching at leaf node
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		// Decision tree needs to be created, one with the 0th index inclusion and one
		// with exclusion
		// output1 would be without inclusion
		// output2 would be with inclusion
		String output1 = output;
		String output2 = output;
		// get the 0th index from input and put with output
		output2 = output + input.charAt(0);
		// remove the 0th index from the input
		input = removeCharAt(input, 0);
		printSubSet(input, output1);
		printSubSet(input, output2);
		return;
	}

	private static String removeCharAt(String input, int indes) {
		StringBuffer sb = new StringBuffer(input);
		sb.deleteCharAt(0);
		return new String(sb);

	}

}
