package org.example.yandex.intern;


import org.example.tree.TreeNode;
import org.example.trie.TrieNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int wordCount = Integer.parseInt(input[0]);
        int questionCount = Integer.parseInt(input[1]);

        String[] arr = new String[wordCount];
        Trie trie = new Trie();

        for (int i = 0; i < arr.length; i++) {
            String word = reader.readLine();
            arr[i] = word;
            trie.insert(word, i);
        }
        //4 a
        StringBuilder res = new StringBuilder();

        for (int j = 0; j < questionCount; j++) {
            String[] question = reader.readLine().split(" ");
            int order = Integer.parseInt(question[0]);
            String prefix = question[1];

            int trRes = trie.searchPrefix(prefix, order);
            if (trRes == -1) {
                if (res.isEmpty()) {
                    res.append(-1);
                } else {
                    res.append("\n");
                    res.append(-1);
                }
            } else {
                if (res.isEmpty()) {
                    res.append(trRes + 1);
                } else {
                    res.append("\n");
                    res.append(trRes + 1);
                }
            }
//            int count = 0;
//
//            for (int k = 0; k < arr.length; k++) {
//                String w = arr[k];
//                if (w.startsWith(prefix)) {
//                    count++;
//                }
//                if (count == order) {
//                    if (res.isEmpty()) {
//                        res.append(k + 1);
//                    } else {
//                        res.append("\n");
//                        res.append(k + 1);
//                    }
//                    break;
//                }
//            }
//            if (count < order) {
//                if (res.isEmpty()) {
//                    res.append(-1);
//                } else {
//                    res.append("\n");
//                    res.append(-1);
//                }
//            }
        }

        System.out.println(res);
    }

    public static class TrieNode implements Comparable<TrieNode> {
        Map<Character, TrieNode> children;
        boolean endOfString;
        int index;

        public TrieNode() {
            children = new HashMap<>();
            endOfString = false;
        }

        @Override
        public int compareTo(TrieNode o) {
            return o.index - index;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
            System.out.println("The Trie has been created");
        }

        public void insert(String word, int index) {
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
            current.index = index;
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

        public int searchPrefix(String word, int count) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = currentNode.children.get(ch);
                if (node == null) {
                    System.out.println("Word: " + word + " does not exist in trie");
                    return -1;
                }
                currentNode = node;
            }
            if (currentNode.endOfString) {
                System.out.println("Word: " + word + " exist in trie");
            } else {
                System.out.println("This Word " + word + " is a prefix of another word but does not exist in trie");
            }
            List<TrieNode> nodes = new ArrayList<>(currentNode.children.values());
            Collections.sort(nodes);
            if (nodes.size() > count) {
                return nodes.get(count - 1).index;
            } else {
                return -1;
            }
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


}
