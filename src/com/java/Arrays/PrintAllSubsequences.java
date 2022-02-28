package com.java.Arrays;

public class PrintAllSubsequences {

	public static void main(String[] args) {
		int[] arr = new int[] { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
//		printAllSubsequences(arr);
//		printLargestSumWithPrefixSumArray(arr);
		lagrestSumKadaneAlgo(arr);
	}

// brute force -> n^3
	private static void printAllSubsequences(int[] arr) {
		int maxsum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int pairsum = 0;
				for (int k = i; k <= j; k++) {
//					System.out.print(arr[k]);
					pairsum += arr[k];
				}
				maxsum = Math.max(pairsum, maxsum);
//				System.out.println();
			}
		}
		System.out.println("Maxsum method 1: " + maxsum);
	}

//maximum sum among all the subsequence array. -> n^2
	private static void printLargestSumWithPrefixSumArray(int[] arr) {
		// create prefix arr
		int maxele = 0;
		int[] prefixarr = new int[arr.length];
		prefixarr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixarr[i] = prefixarr[i - 1] + arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int tempmaxsum = i > 0 ? prefixarr[j] - prefixarr[i - 1] : prefixarr[j];
				maxele = Math.max(maxele, tempmaxsum);
			}
		}
		System.out.println("Maxsum method 2: " + maxele);
	}

//kadane's algorithm
	private static void lagrestSumKadaneAlgo(int[] arr) {
		int maxsum = 0;
		int tempsum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempsum = tempsum + arr[i];
			if (tempsum < 0) {
				tempsum = 0;
			} else {
				maxsum = Math.max(tempsum, maxsum);
			}
		}
		System.out.println(maxsum);
	}

}
