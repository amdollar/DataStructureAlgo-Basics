package com.java.Recursion;

public class PermutationsWithCaseChange {

	public static void main(String[] args) {
		String input = new String("abc");
		String output = new String("");
		printPermutationsWithCaseChange(input, output);
	}

	private static void printPermutationsWithCaseChange(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String output1 = output + input.charAt(0);
		String output2 = output + Character.toUpperCase(input.charAt(0));
		input = removeCharAt(input, 0);
		printPermutationsWithCaseChange(input, output1);
		printPermutationsWithCaseChange(input, output2);
		return;
	}

	private static String removeCharAt(String input, int indes) {
		StringBuffer sb = new StringBuffer(input);
		sb.deleteCharAt(0);
		return new String(sb);

	}

}
