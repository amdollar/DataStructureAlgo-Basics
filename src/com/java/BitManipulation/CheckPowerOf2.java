package com.java.BitManipulation;

public class CheckPowerOf2 {

	public static void main(String[] args) {
		int num = 32;
		System.out.println(checkPowerOfTwo(num));
	}

	private static boolean checkPowerOfTwo(int num) {
		int temp = num & (num - 1);
		int resbit = temp & num;
		if (resbit > 0) {
			return false;
		} else {
			return true;
		}
	}

}
