package org.example.queue.linkedlist;

import org.example.linkedlist.single.SinglyLinkedList;


public class QueueLinkedList {
    SinglyLinkedList list;

    public QueueLinkedList() {
        list = new SinglyLinkedList();
        System.out.println("The Queue created successfully");
    }

    public boolean isEmpty() {
        if (list.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        list.insertInLinkedList(value, list.size);
        System.out.println("The value " + value + " successfully inserted");
    }

    public int deQueue() {
        int value = -1;
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
        } else {
            value = list.head.value;
            list.deletionOfNode(0);
            System.out.println("The value " + value + " dequeued");
        }
        return value;
    }

    public int peek() {
        int value = -1;
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
        } else {
            value = list.head.value;
            System.out.println("The peek value is " + value);
        }

        return value;
    }

    public void deleteQueue() {
        list.head = null;
        list.tail = null;
        System.out.println("The Queue is deleted");
    }

}
