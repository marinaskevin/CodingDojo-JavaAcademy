package com.tries;

public class TrieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        trie.isPrefixValid("car");
        trie.isPrefixValid("ca");
        trie.isPrefixValid("carrot");
        trie.isWordValue("trie");
        trie.isWordValue("ca");
        trie.isWordValue("chip");
        trie.isWordValue("chipper");
        trie.printAllKeys();
	}

}
