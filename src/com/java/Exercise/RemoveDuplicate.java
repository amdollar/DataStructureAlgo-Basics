package com.java.Exercise;

public class RemoveDuplicate {
//remove duplicates from the string and return in sorted order.
	public static void main(String[] args) {
		String str = new String("geekforgeeks");
		String res = removeDuplicates(str);
		System.out.println(res);
	}

	private static String removeDuplicates(String str) {
		int[] frequency = new int[26];
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			frequency[ch - 'a']++;
		}
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > 0) {
				int current = 97 + i;
				char curchar = (char) current;
				sb.append(curchar);
			}
		}
		return sb.toString();
	}

}
