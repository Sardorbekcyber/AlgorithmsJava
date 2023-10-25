package org.example.hashing;

import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public int modeAsciiHash(String word, int M) {
        char[] ch;
        ch = word.toCharArray();
        int i, sum;

        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }

        return sum % M;
    }

    public double getLoadFactor() {
        double loadFactor = usedCellNumber * 1.0 / hashTable.length;
        return loadFactor;
    }

    //Rehash
    public void rehashKeys(String word) {
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
            data.add(word);
        }
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            //Insert in HashTable
            insertInHashTable(s);
        }
    }

    //Insert in HashTable
    public void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modeAsciiHash(word, hashTable.length);
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = i % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location " + newIndex);
                    break;
                } else {
                    System.out.println("Index is already occupied. Trying next empty set");
                }
            }
        }
        usedCellNumber++;
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exist");
        } else {
            System.out.println("\n---------------HashTable---------------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index " + i + ", key: " + hashTable[i]);
            }
        }
    }

    public boolean search(String word) {
        int index = modeAsciiHash(word, hashTable.length);

        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println("The " + word + " found at location " + newIndex);
                return true;
            }
        }

        System.out.println(word + " not found in hash table");
        return false;
    }

    public void deleteKey(String word) {
        int index = modeAsciiHash(word, hashTable.length);
        for (int i=index; i<index+hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println(word + " deleted from hash table");
                return;
            }
        }
        System.out.println(word + " not found in hash table");
    }

}
