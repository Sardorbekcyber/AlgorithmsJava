package org.example.problems.queueViaStacks;

import java.util.Stack;

public class QueueViaStacks {
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStacks() {
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void enqueue(int value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
    }

    public int dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }

    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public static void main(String[] args) {
        QueueViaStacks queueViaStacks = new QueueViaStacks();
        queueViaStacks.enqueue(1);
        queueViaStacks.enqueue(2);
        queueViaStacks.enqueue(3);
        queueViaStacks.enqueue(4);
        queueViaStacks.enqueue(5);
        System.out.println(queueViaStacks.dequeue());
        System.out.println(queueViaStacks.peek());
        System.out.println(queueViaStacks.peek());
        System.out.println(queueViaStacks.size());
    }

}