package com.java.Arrays;

public class LargestElement {

	public static void main(String[] args) {
		int[] arr = new int[] { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		int res = largestEle(arr);
		System.out.println(res);
	}
//	 Linear solution -> Time complexity : n space : 1
	private static int largestEle(int[] arr) {
		int largest = 0;
		for (int i = 0; i < arr.length; i++) {
			largest = Math.max(arr[i], largest);
		}
		return largest;
	}

}
