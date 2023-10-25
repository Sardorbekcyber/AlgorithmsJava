package org.example.hashing;

import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int noOfCellsUsedInHashTable;

    DoubleHashing(int size) {
        hashTable = new String[size];
        noOfCellsUsedInHashTable = 0;
    }

    //Hash Function to be used on Keys
    public int simpleASCIIHashFunction(String x, int M) {
        char[] ch;
        ch = x.toCharArray();
        int i, sum;

        for (sum = 0, i = 0; i < x.length(); i++) {
            sum = sum + ch[i];
        }

        return sum % M;
    }

    //Rehash
    public void rehashKeys(String newStringToBeInserted) {
        noOfCellsUsedInHashTable = 0;
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

    public int addAllDigitsTogether(int sum) {
        int value = 0;
        while (sum > 0) {
            value = sum % 10;
            sum = sum / 10;
        }

        return value;
    }

    public int secondHashFunction(String x, int M) {
        char[] ch = x.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < x.length(); i++) {
            sum += ch[i];
        }
        while (sum > hashTable.length) {
            sum = addAllDigitsTogether(sum);
        }

        return sum % M;
    }

    public double getLoadFactor() {
        return noOfCellsUsedInHashTable * 1.0 / hashTable.length;
    }

    public void insertKeyInHashTable(String value) {
        double loadFactor = getLoadFactor();

        if (loadFactor >= 0.75) {
            rehashKeys(value);
        } else {
            int x = simpleASCIIHashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);

            for (int i = 0; i < hashTable.length; i++) {
                int newIndex = (x + i * y) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = value;
                    System.out.println(value + " inserted at index " + newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " occupied trying next");
                }
            }
        }
        noOfCellsUsedInHashTable++;
    }

    public boolean search(String word) {
        int index = simpleASCIIHashFunction(word, hashTable.length);

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
        int index = simpleASCIIHashFunction(word, hashTable.length);
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
