package org.example.sorting.heap;

public class HeapSortMain {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, 4, 8, 6, 9, 7, 1};
        HeapSort heapSort = new HeapSort(arr);
        heapSort.sort();
        heapSort.printArray();
    }

}
