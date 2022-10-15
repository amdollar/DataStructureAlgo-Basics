package com.java.Arrays;

import java.util.Arrays;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4 };
		double res = findMedianSortedArrays(nums1, nums2);
		System.out.println(res);

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] full = new int[l1 + l2];
		int i = 0;
		for (i = 0; i < l1; i++) {
			full[i] = nums1[i];
		}
		for (int j = 0; j < l2; j++) {
			full[i++] = nums2[j];
		}
		// Sort this array;
		Arrays.sort(full);

		for (int j : full)
			System.out.print(j);
		float res = 0;
		int arrLen = full.length;
		int mid = arrLen/2;
		if (arrLen % 2 == 0) {
			res = (full[mid] + full[mid - 1]) / 2;
		} else {
			res = (full[arrLen / 2]) / 2;
		}
		// System.out.println(res);
		return res;
	}

}
