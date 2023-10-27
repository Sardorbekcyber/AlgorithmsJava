package org.example.sorting.selection;

public class SelectionSort {

    static void selectionSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int minimumIndex = j;
            for (int i = j+1; i < arr.length; i++) {
                if (arr[i] < arr[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            if (minimumIndex != j) {
                int temp = arr[j];
                arr[j] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
