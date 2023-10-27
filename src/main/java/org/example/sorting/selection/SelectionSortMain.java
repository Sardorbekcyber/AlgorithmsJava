package org.example.sorting.selection;

public class SelectionSortMain {

    public static void main(String[] args) {
        int[] arr = {10, 3, 2, 5, 8, 4, 1, 9};
        SelectionSort.selectionSort(arr);
        SelectionSort.printArray(arr);
    }

}
