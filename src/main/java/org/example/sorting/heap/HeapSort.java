package org.example.sorting.heap;

import org.example.tree.binaryHeap.BinaryHeap;

public class HeapSort {

    int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        BinaryHeap binaryHeap = new BinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            binaryHeap.insert(arr[i], "Min");
        }

        for (int j = 0; j < arr.length; j++) {
            arr[j] = binaryHeap.extractHeadOfBP("Min");
        }
    }

    void printArray() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
