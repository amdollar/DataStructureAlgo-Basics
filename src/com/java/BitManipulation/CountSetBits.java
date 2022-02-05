package com.java.BitManipulation;

public class CountSetBits {

	public static void main(String[] args) {
		int num = Integer.MAX_VALUE;
		int numberOfSetBits = countSetBits(num);
		System.out.println("Total number of set bits in " + num + " are : " + numberOfSetBits);
	}

	private static int countSetBits(int num) {
		int count = 0;
		while (num > 0) {
			int temp = num & 1;
			if (temp > 0) {
				count++;
			}
			num = num >> 1;
		}

		return count;
	}

}
