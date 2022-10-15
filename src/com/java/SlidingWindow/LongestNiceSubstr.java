package com.java.SlidingWindow;

public class LongestNiceSubstr {

	public static void main(String[] args) {
		String str = new String("YyzaAay");
		String longest = longestNiceSubstring(str);
		System.out.println(longest);

	}

	public static String longestNiceSubstring(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {

				String temp = s.substring(i, j + 1);
//				System.out.println(temp);
				if (checkNice(temp)) {
					if (res.length() < temp.length()) {
						res = temp;
					}
				}
			}
		}

		return res;
	}

	private static boolean checkNice(String temp) {
		int[] feq = new int[128];
		for (char ch : temp.toCharArray()) {
			int k = (int) ch;
			feq[k]++;
		}
		for (char ch : temp.toCharArray()) {
			if (Character.isLowerCase(ch)) {
				if (feq[ch - 32] == 0) {
					return false;
				}
			} else if (Character.isUpperCase(ch)) {
				if (feq[ch + 32] == 0) {
					return false;
				}
			}
		}
		return true;

	}

}
