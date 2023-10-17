package org.example.tree.binaryTree;

import org.example.tree.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
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
    void postOrder(BinaryTree node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    //LevelOrder Traversal
    void levelOrder() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    //Level Order Search
    void search(String value) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            if (node.value.equals(value)) {
                System.out.println("Found" + value);
                return;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println("Not Found" + value);
    }

    void insert(String value) {
        BinaryTree newNode = new BinaryTree(value);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted new Node at root");
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if (current.left == null) {
                current.left = newNode;
                System.out.println("Successfully Inserted");
                break;
            }
            if (current.right == null) {
                current.right = newNode;
                System.out.println("Successfully Inserted");
                break;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
    }

    //Get Deepest Node of Binary Tree
    BinaryTree getDeepestNode() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        BinaryTree node = null;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }

    //Delete Deepest Node from Binary Tree
    void deleteDeepestNode() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        BinaryTree previous, current = null;

        while (!queue.isEmpty()) {
            previous = current;
            current = queue.poll();
            if (current.left == null) {
                previous.right = null;
                return;
            }
            if (current.right == null) {
                current.left = null;
                return;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
    }

    //Delete Given Node
    void deleteNode(String value) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();

            if (current.value.equals(value)) {
                current.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The Node is deleted");
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        System.out.println("Node does not exist in Binary Tree");
    }

    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted");
    }

}
