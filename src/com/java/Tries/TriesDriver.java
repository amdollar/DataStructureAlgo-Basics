package com.java.Tries;

public class TriesDriver {

	public static void main(String[] args) {
		Tries tries = new Tries();
		tries.push("Anurag");
		boolean res = tries.search("Anurag");

		System.out.println(tries.search("Anura"));
	}

}
