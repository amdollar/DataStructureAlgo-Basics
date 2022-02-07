package com.java.BitManipulation;

public class GetNthBit {
	public static void main(String[] args) {
		int num = 33;
		int bitno = 5;
		int lastBit = getLastBit(num, bitno);
		System.out.println(bitno+" bit of " + num + " is: " + lastBit);
	}

	private static int getLastBit(int num, int bitno) {
		int res = num >> bitno;
		int and = res & 1;
		if (and == 1)
			return 1;
		else
			return 0;
	}
}
