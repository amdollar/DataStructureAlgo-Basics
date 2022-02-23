package com.java.Exercise;

public class AlternateBits {
	public static void main(String[] args) {
		String str = new String("001");
//		String res = flipBits(str);
//		System.out.println(res);
		System.out.println(flipBitsCount(str));
	}

	private static String flipBits(String str) {
		char[] strArr = str.toCharArray();
		int prev = 0;
		int next = 1;

		while (next <= (strArr.length - 1)) {
			char temp1 = strArr[prev];
			char temp2 = strArr[next];
			if (temp1 == temp2) {
				if (temp2 == '0') {
					strArr[next] = '1';
				} else {
					strArr[next] = '0';
				}
			}
			prev++;
			next++;
		}
		return new String(strArr);
	}

	private static int flipBitsCount(String str) {

		int count1 = flipBitsCountWithStarting(str, '0');
		int count2 = flipBitsCountWithStarting(str, '1');
		return Math.min(count1, count2);

	}

	private static int flipBitsCountWithStarting(String str, char expected) {

		int flips = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			if (str.charAt(i) != expected)
				flips++;
			expected = changeFlip(expected);
		}
		return flips;
	}

	private static char changeFlip(char ch) {
		return (ch == '0') ? '1' : '0';
	}
}
