package com.java.Exercise;

// This is a classic example of displacement
//	For given directions we need to calculate the displacement.
public class ShortestPath {

	public static void main(String[] args) {
		char[] directions = new char[] { 'S', 'N', 'N', 'N', 'E', 'W', 'E' };
		int[] displacement = findDisplacement(directions);
		for (int i : displacement) {
			System.out.println(i);
		}
		printSortestPath(displacement);
	}

	private static void printSortestPath(int[] displacement) {
		int x = displacement[0];
		int y = displacement[1];
		while (y > 0) {
			System.out.println("N");
			y--;
		}
		while (x > 0) {
			System.out.println("E");
			x--;
		}

	}

	// need to calculate the final postion of a person after making these many
	// moves.
	// we will have calculate these using x and y axis
	private static int[] findDisplacement(char[] directions) {
		int x = 0;
		int y = 0;

		for (char c : directions) {
			switch (c) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			}
		}
		int arr[] = new int[] { x, y };
		return arr;
	}

}
