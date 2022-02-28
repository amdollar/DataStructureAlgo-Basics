package com.java.Tries;

import java.util.HashMap;

//two operations are supported : insert and delete.
// one node class is also required that would contain: char, hashmap and boolean value
public class Tries {
	Node root;

	Tries() {
		root = new Node('\0');
	}

	// start from the root node.
	// keep advancing the pointer node after each insertion of Node.
	// after all the chars are processed then set last node as is Terminal
	public void push(String word) {
		Node pointer = root;
		for (char ch : word.toCharArray()) {
			if (!pointer.map.containsKey(ch)) {
				Node temp = new Node(ch);
				pointer.map.put(ch, temp);
			}
			pointer = pointer.map.get(ch);
		}
		pointer.isTerminal = true;
	}

	public boolean search(String word) {
		if (!root.map.containsKey(word.charAt(0))) {
			return false;
		}
		Node temp = root.map.get(word.charAt(0));
		for (int i = 1; i < word.toCharArray().length; i++) {
			if (temp.map.containsKey(word.charAt(i))) {
				temp = temp.map.get(word.charAt(i));
			}
		}
		return temp.isTerminal;
	}
}

class Node {
	char ch;
	HashMap<Character, Node> map;
	boolean isTerminal;

	Node(char ch) {
		this.ch = ch;
		this.isTerminal = false;
		this.map = new HashMap<>();
	}
}
