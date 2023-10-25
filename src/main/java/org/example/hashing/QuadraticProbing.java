package org.example.hashing;

import java.util.ArrayList;

public class QuadraticProbing {
    String[] hashTable;
    int usedCellNumber;

    QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    //Hash function to be used on keys
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
    public void rehashKeys(String newStringToBeInserted) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
        }
        data.add(newStringToBeInserted);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            //Insert in HashTable
            insertKeyInHashTable(s);
        }
    }

    public void insertKeyInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modeAsciiHash(word, hashTable.length);
            int counter = 0;
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = (index + counter * counter) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println(word + " has been inserted successfully at location " + newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " already occupied trying next");
                }
                counter++;
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

}
