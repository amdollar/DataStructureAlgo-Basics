package com.java.Exercise;

public class StringCompression {

	public static void main(String[] args) {
		String str = new String("abcdd");
		String compressedString = compressString(str);
		System.out.println(compressedString);
	}

	// assuming that all the characters of given string are in small case.
	private static String compressString(String str) {
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[26];
		for (char ch : str.toCharArray()) {
			arr[ch - 'a']++;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 1) {
				int newch = 97 + (char) i;
				char ch = (char) newch;
				sb.append(ch);
				sb.append(arr[i]);
			} else if (arr[i] == 1) {
				int newch = 97 + (char) i;
				char ch = (char) newch;
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
