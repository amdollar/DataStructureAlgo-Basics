package com.java.Recursion;

public class SpellNumber {

	public static void main(String[] args) {
		int num = 123121323;
		printSpell(num);

	}

	private static void printSpell(int num) {
		if (num == 0) {
			return;
		}
		int temp = num % 10;
		printSpell(num / 10);
		switch (temp) {
		case 0:
			System.out.print("Zero");
			break;
		case 1:
			System.out.print("One");
			break;
		case 2:
			System.out.print("Two");
			break;
		case 3:
			System.out.print("Three");
			break;
		case 4:
			System.out.print("Four");
			break;
		default:
			System.out.print("_");
		}
	}

}
