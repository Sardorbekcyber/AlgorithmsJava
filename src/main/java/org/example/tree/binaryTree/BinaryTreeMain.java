package org.example.tree.binaryTree;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTreeLL treeLL = new BinaryTreeLL();
        treeLL.insert("N1");
        treeLL.insert("N2");
        treeLL.insert("N3");
        treeLL.insert("N4");
        treeLL.insert("N5");
        treeLL.insert("N6");

        treeLL.levelOrder();
        treeLL.deleteDeepestNode();
        System.out.println();
        treeLL.levelOrder();
    }

}
