package com.java.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class CountOccurrencesOfAnagram {

	public static void main(String[] args) {
		String str = "abab";
		String pattern = "ab";
		int res = solve(str, pattern, str.length(), pattern.length());
		System.out.println(res);
	}

	private static int solve(String str, String pattern, int l1, int l2) {
		List<Character> data = new ArrayList<>();
		int res = 0;
		int i = 0;
		int j = 0;
		while (j < l1) {
			data.add(str.charAt(j));
			if (j - i + 1 < l2) {
				j++;
			} else if (j - i + 1 == l2) {
				int temp = 0;
				for (char ch : pattern.toCharArray()) {
					if (data.contains(ch)) {
						temp++;
					}
					if (temp == l2) {
						res++;
					}
				}
				data.remove(0);
				i++;
				j++;
			}

		}
		return res;
	}

}
