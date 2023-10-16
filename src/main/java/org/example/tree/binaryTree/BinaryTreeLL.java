package org.example.tree.binaryTree;

import org.example.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    public BinaryTree root;

    public BinaryTreeLL() {
        this.root = null;
    }

    //PreOrder Traversal
    void preOrder(BinaryTree node) {
        if (node == null) return;

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //InOrder Traversal
    void inOrder(BinaryTree node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    //PostOrder Traversal
    void postOrder(BinaryTree node){
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    //LevelOrder Traversal
    void levelOrder() {
        if (root == null) return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            System.out.println(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

}
