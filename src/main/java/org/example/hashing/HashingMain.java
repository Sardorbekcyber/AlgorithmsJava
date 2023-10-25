package org.example.hashing;

public class HashingMain {
    public static void main(String[] args) {
        quadraticProbingDemo();
    }

    public static void directChainingDemo() {
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

    public static void linearProbingDemo() {
        LinearProbing linearProbing = new LinearProbing(13);

        linearProbing.insertInHashTable("The");
        linearProbing.insertInHashTable("quick");
        linearProbing.insertInHashTable("brown");
        linearProbing.insertInHashTable("fox");
        linearProbing.insertInHashTable("over");

        linearProbing.search("fox");
        linearProbing.deleteKey("fox");
        linearProbing.search("fox");
    }

    public static void quadraticProbingDemo() {
        QuadraticProbing quadraticProbing = new QuadraticProbing(13);

        quadraticProbing.insertKeyInHashTable("The");
        quadraticProbing.insertKeyInHashTable("quick");
        quadraticProbing.insertKeyInHashTable("brown");
        quadraticProbing.insertKeyInHashTable("fox");
        quadraticProbing.insertKeyInHashTable("over");
        quadraticProbing.insertKeyInHashTable("lazy");

        quadraticProbing.deleteKey("lazy");
        quadraticProbing.displayHashTable();
    }

    public static void doubleHashingDemo() {
        DoubleHashing doubleHashing = new DoubleHashing(13);

        doubleHashing.insertKeyInHashTable("The");
        doubleHashing.insertKeyInHashTable("quick");
        doubleHashing.insertKeyInHashTable("brown");
        doubleHashing.insertKeyInHashTable("fox");
        doubleHashing.insertKeyInHashTable("over");
        doubleHashing.insertKeyInHashTable("lazy");

        doubleHashing.deleteKey("lazy");
        doubleHashing.displayHashTable();
    }

}
