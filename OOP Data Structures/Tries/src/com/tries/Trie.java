package com.tries;

import java.util.Set;

public class Trie {
public Node root;

	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
		// gets the root node;
		Node currentNode = this.root;
		
		// iterates over every character in the word
		for(int i = 0; i < word.length(); i++) {
			// currentLetter is just the character / letter at the iteration
			Character currentLetter = word.charAt(i);
			// ask if the current letter is in the map of the current node
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child); 
			} 
			
			currentNode = child;
		}
		currentNode.isCompleteWord = true;
	}
	
	boolean isPrefixValid(String prefix) {
		Node currentNode = this.root;
		boolean isPrefixValid = true;
		for(int i=0; i < prefix.length(); i++) {
			Character currentLetter = prefix.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				isPrefixValid = false;
				break;
			}
			currentNode = child;
		}
		if(isPrefixValid) {
			System.out.println("Prefix '"+prefix+"' is valid.");
		}
		else {
			System.out.println("Prefix '"+prefix+"' is invalid.");
		}
		return isPrefixValid;
	}

	boolean isWordValue(String word) {
		Node currentNode = this.root;
		boolean isWordValue = false;
		for(int i=0; i < word.length(); i++) {
			Character currentLetter = word.charAt(i);
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				System.out.println("'"+word+"' is not a valid word.");
				return false;
			}
			currentNode = child;
		}
		if(currentNode.isCompleteWord) {
			isWordValue = true;
			System.out.println("'"+word+"' is a valid word.");
		}
		else
		{
			System.out.println("'"+word+"' is not a valid word.");
		}
		return isWordValue;
	}

	void printAllKeys() {
		Set<Character> keys = this.root.children.keySet();
		for(Character key : keys) {
			System.out.println(key);
		}
	}
}
