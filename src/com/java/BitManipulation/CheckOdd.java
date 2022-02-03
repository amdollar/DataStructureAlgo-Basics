package com.java.BitManipulation;

// checking if a given number is odd or even using bit manipulation
public class CheckOdd {

	public static void main(String[] args) {
		int n = 10;
		int test = n & 1;
		if (test == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}

}
