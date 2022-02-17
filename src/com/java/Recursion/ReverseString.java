package com.java.Recursion;

public class ReverseString {
	static int in = -1;

	public static void main(String[] args) {
		char[] chars = new char[] { 'h', 'e', 'l', 'l', 'o' };
		for (char c : chars) {
			System.out.print(c);
		}
		System.out.println();
		reverseString(chars);
		for (char c : chars) {
			System.out.print(c);
		}
		System.out.println();
	}

	private static void reverseString(char[] chars) {
		reverseStringHelper(chars, 0);
	}

	private static void reverseStringHelper(char[] chars, int index) {
		if (index >= chars.length / 2) {
			return;
		}

		// do swapping for first and last elements.
		char temp = chars[index];
		chars[index] = chars[chars.length - 1 - index];
		chars[chars.length - 1 - index] = temp;

		reverseStringHelper(chars, index + 1);
	}

}
