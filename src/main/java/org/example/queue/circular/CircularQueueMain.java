package org.example.queue.circular;

public class CircularQueueMain {

    public static void main(String[] args) {
        CircularQueueArray circularQueueArray = new CircularQueueArray(3);

        circularQueueArray.enQueue(1);
        circularQueueArray.enQueue(2);

        System.out.println("isEmpty " + circularQueueArray.isEmpty());
        System.out.println("isFull " + circularQueueArray.isFull());
        System.out.println(circularQueueArray.peek());
        circularQueueArray.deQueue();
        System.out.println(circularQueueArray.peek());

        circularQueueArray.enQueue(3);
        circularQueueArray.enQueue(4);

        System.out.println("isEmpty " + circularQueueArray.isEmpty());
        System.out.println("isFull " + circularQueueArray.isFull());

        circularQueueArray.deleteQueue();
    }

}
