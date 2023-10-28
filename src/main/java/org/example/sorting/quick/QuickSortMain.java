package org.example.sorting.quick;

public class QuickSortMain {

    public static void main(String[] args) {
        int[] arr = {10, 3, 2, 5, 8, 4, 1, 9};

        QuickSort.quickSort(arr, 0, arr.length - 1);

        QuickSort.printArray(arr);
    }

}
