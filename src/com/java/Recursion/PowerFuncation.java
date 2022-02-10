package com.java.Recursion;

public class PowerFuncation {

	public static void main(String[] args) {
		int n = 3;
		int p = 4;
//		int res = findPower(n, p);
		int res1 = findPowerOptimized(n, p);

		System.out.println(res1);
//		System.out.println(res);
	}

	private static int findPower(int n, int p) {
		if (p == 1) {
			return n;
		}
		return n * findPower(n, p - 1);
	}

	// find power in optimized manner
	// if p is even then a(n) = (a ^ (n/2)) ^2
	// if p is odd then a(n) = a * (a ^ (n/2)) ^2
	private static int findPowerOptimized(int n, int p) {
		if (p == 0) {
			return 1;
		}
		int res = findPowerOptimized(n, p / 2);
		int temp = res * res;
		if (p % 2 != 0) {
			return n * temp;
		}
		return temp;
	}

}
