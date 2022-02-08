package com.java.BitManipulation;

public class DecimalToBinary {

	public static void main(String[] args) {
		int input = 10;
		int res = convert(input);
		System.out.println(res);
	}

	private static int convert(int input) {
		int res = 0;
		int power = 1;
		while (input > 0) {
			int leastBit = input & 1;
			res += (power * leastBit);
			power *= 10;
			input = (input >> 1);
		}
		return res;
	}

}
