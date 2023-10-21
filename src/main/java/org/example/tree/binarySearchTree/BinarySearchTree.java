package org.example.tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    //Insert Node to BST
    private BSTNode insert(BSTNode currentNode, int value) {
        if (currentNode == null) {
            BSTNode node = new BSTNode();
            node.value = value;
            System.out.println("Value successfully inserted");
            return node;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    //BST PreOrder Traversal
    void preOrder(BSTNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //BST InOrder Traversal
    void inOrder(BSTNode node) {
        if (node == null) return;

        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    //BST PostOrder Traversal
    void postOrder(BSTNode node) {
        if (node == null) return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

    //BST Level Order Traversal
    void levelOrder() {
        if (root == null) return;
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    //Search value in BST
    BSTNode search(BSTNode node, int value) {
        if (node == null) {
            System.out.println("Value " + value + " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value " + value + " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    //Delete Node
    public BSTNode deleteNode(BSTNode root, int value) {
        if (root == null) {
            System.out.println("The value " + value + " not found");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BSTNode temp = root;
                BSTNode minimumNodeForRight = minimumNode(temp.right);
                root.value = minimumNodeForRight.value;
                root.right = deleteNode(root.right, minimumNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    //Minimum node
    public static BSTNode minimumNode(BSTNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    //Delete BST
    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }

}
