package com.java.Recursion;

public class LetterCasePermutation {

	public static void main(String[] args) {
		String input = new String("aB3cD1");
		String output = new String("");
		solve(input, output);

	}

	private static void solve(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String output1 = output;
		String output2 = output;
		if (Character.isAlphabetic(input.charAt(0))) {
			output1 = output + Character.toUpperCase(input.charAt(0));
			output2 = output + Character.toLowerCase(input.charAt(0));
			input = removeCharAt(input, 0);
			solve(input, output1);
			solve(input, output2);
		} else {
			output1 = output + input.charAt(0);
			input = removeCharAt(input, 0);
			solve(input, output1);
		}

	}

	private static String removeCharAt(String input, int indes) {
		StringBuffer sb = new StringBuffer(input);
		sb.deleteCharAt(0);
		return new String(sb);

	}

}
