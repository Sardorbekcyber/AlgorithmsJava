package org.example.trie;

import org.example.tree.TreeNode;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The Trie has been created");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word + " in Trie");
    }

    //Search for a word in Trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                System.out.println("Word: " + word + " does not exist in trie");
                return false;
            }
            currentNode = node;
        }
        if (currentNode.endOfString) {
            System.out.println("Word: " + word + " exist in trie");
        } else {
            System.out.println("This Word " + word + " is a prefix of another word but does not exist in trie");
        }
        return currentNode.endOfString;
    }

    public boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        //1-case: Some others words prefix is same as this words prefix
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }
        //2-case: This word is prefix of some other word
        if (index == word.length() - 1) {
            if (!currentNode.children.isEmpty()) {
                currentNode.endOfString = false;
                return false;
            }
            //2-case: This word is not prefix of some other word
            else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        //3-case Some other word is prefix of this word;
        if (currentNode.endOfString) {
            delete(currentNode, word, index + 1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index + 1);
        if (canThisNodeBeDeleted) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }

}
