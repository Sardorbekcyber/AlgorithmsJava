package org.example.stack.array;

public class StackArrayMain {

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(4);
        System.out.println(stackArray.isEmpty());
        System.out.println(stackArray.isFull());

        stackArray.push(4);
        stackArray.push(2);
        stackArray.push(6);
        stackArray.push(9);

        System.out.println(stackArray.peek());
        System.out.println(stackArray.peek());
    }

}
