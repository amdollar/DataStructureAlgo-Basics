package com.java.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccountsMerge50 {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();

		String[][] ids = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
				{ "John", "johnsmith@mail.com", "john00@mail.com" }, { "Mary", "mary@mail.com" },
				{ "John", "johnnybravo@mail.com" } };

		accounts = Arrays.stream(ids).map(Arrays::asList).collect(Collectors.toList());
		
		

	}

}
