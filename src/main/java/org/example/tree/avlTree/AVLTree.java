package org.example.tree.avlTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    BinaryNode root;

    public AVLTree() {
        root = null;
    }

    //AVL PreOrder Traversal
    void preOrder(BinaryNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //AVL InOrder Traversal
    void inOrder(BinaryNode node) {
        if (node == null) return;

        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    //AVL PostOrder Traversal
    void postOrder(BinaryNode node) {
        if (node == null) return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

    //AVL Level Order Traversal
    void levelOrder() {
        if (root == null) return;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    //Search value in AVL
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value " + value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println("Value " + value + " found in AVL");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    //Insert Node to AVL
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode node = new BinaryNode();
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

    //Delete AVL
    public void deleteAVL() {
        root = null;
        System.out.println("AVL has been deleted successfully");
    }

    //Get height of node
    public int getHeight(BinaryNode node) {
        if (root == null) {
            return 0;
        }
        return node.height;
    }

    //Rotate Right
    private BinaryNode rotateRight(BinaryNode imbalancedNode) {
        BinaryNode newRoot = imbalancedNode.left;
        imbalancedNode.left = imbalancedNode.left.right;
        newRoot.right = imbalancedNode;
        imbalancedNode.height = 1 + Math.max(getHeight(imbalancedNode.left), getHeight(imbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //Rotate left
    private BinaryNode rotateLeft(BinaryNode imbalancedNode) {
        BinaryNode newRoot = imbalancedNode.right;
        imbalancedNode.right = imbalancedNode.right.left;
        newRoot.left = imbalancedNode;
        imbalancedNode.height = 1 + Math.max(getHeight(imbalancedNode.left), getHeight(imbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public int getBalance(BinaryNode node) {
        if (node == null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    //Insert Node
    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {
            //Left.left condition - we need right rotation
            return rotateRight(node);
        }
        if (balance > 1 && nodeValue > node.left.value) {
            //Left.Right condition
            rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && nodeValue > node.right.value) {
            //Right.right condition
            return rotateRight(node);
        }
        if (balance < -1 && nodeValue < node.right.value) {
            //Right.left condition
            rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    //Insert Node to AVL tree
    void insert(int value) {
        root = insert(root, value);
    }

    //Minimum Node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) return root;
        return minimumNode(root.left);
    }

    //Delete Node
    public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("The value not found in AVL tree");
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left != null && node.right != null) {
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            //Right rotation
            return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            //Left.Right rotation
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            //Right.right
            return rotateLeft(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            //Right.left
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

}
