package org.example.tree.binaryTree;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTreeArr treeLL = new BinaryTreeArr(10);
        treeLL.insert("N1");
        treeLL.insert("N2");
        treeLL.insert("N3");
        treeLL.insert("N4");
        treeLL.insert("N5");
        treeLL.insert("N6");

        treeLL.inOrder(1);
        System.out.println();
        treeLL.preOrder(1);
    }

}
