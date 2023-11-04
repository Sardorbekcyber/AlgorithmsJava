package org.example.queue.linkedlist;

public class QueueLinkedListMain {

    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        System.out.println(queueLinkedList.isEmpty());

        queueLinkedList.enQueue(5);
        queueLinkedList.enQueue(7);

        queueLinkedList.peek();
        queueLinkedList.peek();
        queueLinkedList.deQueue();

        queueLinkedList.enQueue(10);
        queueLinkedList.deQueue();
        queueLinkedList.peek();

        System.out.println(queueLinkedList.isEmpty());
    }

}
