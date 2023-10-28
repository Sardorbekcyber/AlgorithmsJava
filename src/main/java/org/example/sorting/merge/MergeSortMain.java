package org.example.sorting.merge;

public class MergeSortMain {

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 2, 6, 7, 8, 9, 1, 4};
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        MergeSort.printArray(arr);
    }

}
