package org.example.queue.array;

public class QueueArrayMain {

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(4);
        System.out.println(queueArray.isFull());
        System.out.println(queueArray.isEmpty());
        queueArray.enQueue(1);
        queueArray.enQueue(2);
        queueArray.enQueue(3);
        queueArray.enQueue(4);
        queueArray.deQueue();
        queueArray.peek();
        queueArray.enQueue(5);
        queueArray.deleteQueue();
        queueArray.isEmpty();
    }

}
