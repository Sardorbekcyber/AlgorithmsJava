package org.example.tree.binaryTree;

public class BinaryTreeArr {
    String[] arr;
    int lastIndexUsed;

    public BinaryTreeArr(int size) {
        arr = new String[size + 1];
        this.lastIndexUsed = 0;
        System.out.println("Blank Tree of Size" + size + "has been created");
    }

}
