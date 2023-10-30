package org.example.stack;

public class Stack {
    int[] arr;
    int topOfStack;

    public Stack(int size) {
        arr = new int[size];
        topOfStack = -1;
        System.out.println("The stack is created with size of: " + size);
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public boolean isFull() {
        return topOfStack == arr.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is Full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value " + value + " is successfully inserted");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is Empty");
            return -1;
        } else {
            int topElement = arr[topOfStack];
            topOfStack--;
            return topElement;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is Empty");
            return -1;
        } else {
            return arr[topOfStack];
        }
    }

}
