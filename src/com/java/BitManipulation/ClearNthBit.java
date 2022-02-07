package com.java.BitManipulation;

public class ClearNthBit {
	public static void main(String[] args) {
		int num = 13;
		int bitno = 2;
		int res = clearNthBit(num, bitno);
		System.out.println("After clearing " + bitno + " from " + num + " : " + res);
	}

	private static int clearNthBit(int num, int bitno) {
		int mask = (1 << bitno);
		int temp = num & mask;

		return ~(temp) & num;
	}
}
