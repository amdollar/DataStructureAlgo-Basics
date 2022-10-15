package com.java.Arrays;

public class FindMajorityElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		int res = findMajorityElement(arr);
		System.out.println(res);
	}

	private static int findMajorityElement(int[] arr) {
		int count = 0;
		int candidate = 0;
		for (int i : arr) {
			if (count == 0) {
				candidate = i;
			}
			if (i == candidate) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

}
