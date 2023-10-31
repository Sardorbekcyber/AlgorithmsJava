package org.example.stack.linkedlist;

public class StackLinkedListMain {

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.peek());
        stack.deleteStack();
    }

}
