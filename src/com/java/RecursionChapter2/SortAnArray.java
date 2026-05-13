package com.java.RecursionChapter2;

public class SortAnArray {

	public static void main(String[] args) {
		int[] arr = { 0, 4, 1, 2 };

		sort(arr, arr.length);

	}

	private static int sort(int[] arr, int len) {

		if (len == 0) {
			return arr[len];
		}

		int last = sort(arr, len - 1);
		
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] < last) {
				int temp = arr[i];
				arr[i] = last;
				arr[i+1] = temp;
			}
				
		}
		
		return 0;

	}

}
