package com.java.BitManipulation;

public class ClearRangeBits {

	public static void main(String[] args) {
		int n = 31;
		int i = 1;
		int j = 3;
		int res = clearRangeBits(n, i, j);
		System.out.println("After setting bits from " + i + "to " + j + " : " + res);
	}

	private static int clearRangeBits(int n, int i, int j) {
		int a = (~0) << (j + 1);
		int b = (1 << i) - 1;
		int mask = a | b;
		return mask & n;
	}

}
