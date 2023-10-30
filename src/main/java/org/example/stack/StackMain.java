package org.example.stack;

public class StackMain {

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        stack.push(4);
        stack.push(2);
        stack.push(6);
        stack.push(9);

        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }

}
