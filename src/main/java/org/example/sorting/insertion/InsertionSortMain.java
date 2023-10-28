package org.example.sorting.insertion;

public class InsertionSortMain {

    public static void main(String[] args) {
        int[] arr = {10, 3, 2, 5, 4, 8, 7, 9};

        InsertionSort.insertionSort(arr);
        InsertionSort.printArray(arr);
    }

}
