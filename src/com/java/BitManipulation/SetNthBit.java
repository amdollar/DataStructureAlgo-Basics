package com.java.BitManipulation;

public class SetNthBit {

	public static void main(String[] args) {
		int num = 2;
		int bitNo = 2;
		int res = setNthBit(num, bitNo);
		System.out.println("After setting " + bitNo + " from " + num + " : " + res);
	}

	private static int setNthBit(int num, int bitNo) {
		int mask = (1 << bitNo);
		return num | mask;
	}

}
