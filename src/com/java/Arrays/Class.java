package com.java.Arrays;

public class Class {

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trapwater(arr));
		System.out.println(trappedWaterPreSuff(arr));
	}

	private static int trapwater(int arr[]) {
		// for each index we need to find left max and right max
		// after that we need to find the minimum of these two boundries.
		// with that minimum we need to subtract the current depth of height(index)
		// sum all these to get the amount of trapped water.
		int trappedWater = 0;
		for (int i = 0; i < arr.length; i++) {
			// find the left boundry
			int j = i;
			int leftB = 0, rightB = 0;
			while (j >= 0) {
				leftB = Math.max(arr[j], leftB);
				j--;
			}
			// find the right boundary
			j = i;
			while (j < arr.length) {
				rightB = Math.max(arr[j], rightB);
				j++;
			}
			// find min of them, subtract with the currect
			int min = Math.min(leftB, rightB);
			// subtract with the current and add with res;
			trappedWater = trappedWater + (min - arr[i]);
		}
		return trappedWater;
	}
	// we can further optimize this to not use the while loops for each index to
	// calculate the max boundries;
	// for this we can use prefix and suffix boundries and for each index we can
	// grab the min of them in o1;

	private static int trappedWaterPreSuff(int[] arr) {
		int trappedWater = 0;
		int n = arr.length;

		int prefix[] = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = Math.max(prefix[i - 1], arr[i]);
		}
		int suffix[] = new int[arr.length];
		suffix[n - 1] = arr[n - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			suffix[i] = Math.max(suffix[i + 1], arr[i]);
		}
		// now for current index find min of left right and reduce it to current and add
		// to res
		for (int i = 0; i < arr.length; i++) {
			trappedWater += Math.min(prefix[i], suffix[i]) - arr[i];
		}

		return trappedWater;
	}

}
