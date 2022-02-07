package com.java.BitManipulation;

public class GetNthBit {
	public static void main(String[] args) {
		int num = 33;
		int bitno = 5;
		int lastBit = getLastBit(num, bitno);
		System.out.println(bitno + " bit of " + num + " is: " + lastBit);
		int nthbit = getLastBitAnotherWay(num, bitno);
		System.out.println(bitno + " bit of " + num + " is: " + nthbit);
	}

// by moving the bits to bitno and then doing the & then if the last digit is 1 then return 1 else 0;
	private static int getLastBit(int num, int bitno) {
		int res = num >> bitno;
		int and = res & 1;
		if (and == 1)
			return 1;
		else
			return 0;
	}

	// another way is to use the mask bit as making the significant bitno in the
	// mask as 1 then do the & if the result is > 1 then return 1 else 0
	private static int getLastBitAnotherWay(int num, int bitno) {
		int mask = (1 << bitno);
		return (mask & num) > 1 ? 1 : 0;
	}
}
