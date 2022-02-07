package com.java.BitManipulation;

public class ReplaceGivenBits {

	public static void main(String[] args) {
		int num = 15;
		int givenbits = 2;
		int i = 1;
		int j = 3;
		int res = updateBits(num, givenbits, i, j);
		System.out.println("After setting " + givenbits + "to " + num + " result: " + res);

	}

	private static int updateBits(int num, int givenbits, int i, int j) {
		// first clear the bits in the range
		// then add additional right bits in the givenbits
		// perform or op between new givenbits and num

		int a = (~0) << (j + 1);
		int b = (1 << i) - 1;
		int mask = a | b;
		int num1 = num & mask;

		int num2 = givenbits << i;
		int res = num2 | num1;
		return res;
	}

}
