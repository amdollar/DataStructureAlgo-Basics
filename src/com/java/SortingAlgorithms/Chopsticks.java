package com.java.SortingAlgorithms;

import java.util.Arrays;

public class Chopsticks {

	public static void main(String[] args) {
		int[] lengths = new int[] { 1, 3, 3, 9, 4 };
		int difference = 2;
		int res = pairSticks(lengths, difference);
		System.out.println(res);
	}

	private static int pairSticks(int[] lengths, int difference) {
		int count = 0;
		// sort the array [1,3,3,4,9]
		Arrays.sort(lengths);
		// calculate the difference of i and i+1
		for (int i = 1; i < lengths.length; i++) {
			int temp = lengths[i] - lengths[i - 1];
			if (temp <= difference) {
				count++;
				i++;
			}
		}
		// if diff is < difference then update count else advance pointer to next
		// element and repeate

		return count;
	}

}
