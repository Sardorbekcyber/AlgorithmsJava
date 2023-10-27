package org.example.sorting.bubble;

public class BubbleSortMain {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {10, 5, 30, 6, 50, 12, 40, 21};
        bubbleSort.bubbleSort(arr);
        bubbleSort.printArray(arr);
    }

}
