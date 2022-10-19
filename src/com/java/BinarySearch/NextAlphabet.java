package com.java.BinarySearch;

public class NextAlphabet {

	public static void main(String[] args) {
		char[] chars = new char[] { 'a', 'b', 'd', 'e', 'f' };
		char ele = 'a';
		int res = findNextElement(chars, ele);
		System.out.println(res);
	}

	private static int findNextElement(char[] chars, char ele) {
		int res = -1;
		int start = 0;
		int end = chars.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (chars[mid] == ele) {
				start = mid + 1;
			} else if (chars[mid] > ele) {
				if (chars[mid] > res) {
					res = mid;
				}
				end = mid - 1;
			} else if (chars[mid] < ele) {
				start = mid + 1;
			}
		}
		return res;
	}

}
