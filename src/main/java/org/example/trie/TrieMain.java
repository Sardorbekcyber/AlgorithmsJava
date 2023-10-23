package org.example.trie;

public class TrieMain {

    public static void main(String[] args) {
        Trie newTrie = new Trie();

        newTrie.insert("API");
        newTrie.insert("APIS");

        boolean res = newTrie.search("APS");

        newTrie.search("APIS");

        newTrie.delete("API");

        newTrie.search("API");
    }

}
