package com.java.BitManipulation;

public class SetLastNBitsToZero {
	public static void main(String[] args) {
		int num = 15;
		int bitNo = 2;
		int res = setLastNBitsToZero(num, bitNo);
		System.out.println("After setting last" + bitNo + "to 0 : " + res);
	}

	private static int setLastNBitsToZero(int num, int bitNo) {
		// take a number with all 1
		// make last bitNo digit to 0.
		// do & with this mask and num

		int mask = (~0) << bitNo;

		return (num & mask);
	}

}
