package com.java.Recursion;

public class JoshephsProblem {

	public static void main(String[] args) {
		int n = 7;
		int k = 3;
		int arr[] = new int[n];
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = i;
		}
		int index = 0;
		solve(arr, n, k - 1, index);

	}

	private static void solve(int[] arr, int n, int k, int index) {
		// base condition: need to return the last man remaining
		if (n == 1) {
			System.out.print(arr[0]);
			return;
		}
		// hypothesis: need to run the cycle after elimination of one person each time
		// also index calculation in such a way that the ind should not exceed the arr
		// len and should
		// come in circular
		index = (index + k) % n;
		removeAndSwap(arr, index);
		solve(arr, n - 1, k, index);
	}

	private static void removeAndSwap(int[] arr, int ind) {
		for (int i = ind; i < arr.length - 1; i++) {
			arr[ind] = arr[++ind];
		}

	}

}
