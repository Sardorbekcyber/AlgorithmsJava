package org.example.tree.binaryTree;

public class BinaryTreeArr {
    String[] arr;
    int lastIndexUsed;

    public BinaryTreeArr(int size) {
        arr = new String[size + 1];
        this.lastIndexUsed = 0;
        System.out.println("Blank Tree of Size" + size + "has been created");
    }

    //Check If array is Full
    Boolean isFull() {
        return arr.length - 1 == lastIndexUsed;
    }

    //Insert Value to BinaryTree
    void insert(String value) {
        if (!isFull()) {
            arr[lastIndexUsed + 1] = value;
            lastIndexUsed++;
            System.out.println("The value of " + value + " has been inserted");
        } else {
            System.out.println("Binary Tree is Full");
        }
    }

    //PreOrder Traversal
    public void preOrder(int index) {
        if (index > lastIndexUsed) return;
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    //InOrder Traversal
    public void inOrder(int index) {
        if (index > lastIndexUsed) return;

        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    //PostOrder Traversal
    public void postOrder(int index) {
        if (index > lastIndexUsed) return;

        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    //Level Order Traversal
    public void levelOrder() {
        for (int i = 1; i <= lastIndexUsed; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Search Value in Tree
    public int search(String value) {
        for (int i = 1; i <= lastIndexUsed; i++) {
            if (value.equals(arr[i])) {
                System.out.println("Value Exists at location " + i);
                return i;
            }
        }
        System.out.println("Value does not exist in BT");
        return -1;
    }

    //Delete Value from Three
    public void delete(String value) {
        int location = search(value);
        if (location == -1) return;

        arr[location] = arr[lastIndexUsed];
        lastIndexUsed--;
        System.out.println("The Node Successfully deleted");
    }

    //Delete Binary Tree
    public void deleteBinaryTree() {
        try {
            arr = null;
            System.out.println("Tree has been successfuly deleted");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree");
        }
    }

}
