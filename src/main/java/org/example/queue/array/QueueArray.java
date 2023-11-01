package org.example.queue.array;

public class QueueArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue of size " + size + " created successfully");
    }

    public boolean isFull() {
        return topOfQueue == arr.length - 1;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1 || beginningOfQueue == arr.length;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The Queue is Full!");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Value " + value + " successfully inserted");
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Value " + value + " successfully inserted");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }
            System.out.println("The value " + result + " dequeued");
            return result;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            int result = arr[beginningOfQueue];
            System.out.println("The peek value is " + result);
            return result;
        } else {
            System.out.println("The queue is empty");
            return -1;
        }
    }

    public void deleteQueue() {
        arr = null;
        System.out.println("The queue is successfully deleted");
    }

}
