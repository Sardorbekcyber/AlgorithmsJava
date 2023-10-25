package org.example.hashing;

public class HashingMain {
    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(13);

        directChaining.insertToHashTable("The");
        directChaining.insertToHashTable("quick");
        directChaining.insertToHashTable("brown");
        directChaining.insertToHashTable("fox");
        directChaining.insertToHashTable("over");

        directChaining.deleteKeyHashTable("fox");
        directChaining.deleteKeyHashTable("wolf");

        directChaining.displayHashTable();
    }
}
