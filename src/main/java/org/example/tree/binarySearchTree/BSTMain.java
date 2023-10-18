package org.example.tree.binarySearchTree;

public class BSTMain {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(9);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(7);

        System.out.println(tree.root.value);

        tree.inOrder(tree.root);
    }

}
