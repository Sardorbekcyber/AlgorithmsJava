package org.example.sorting.quick;

public class QuickSort {

    static int partition(int[] array, int start, int end) {
        int pivotNumber = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (array[j] <= array[pivotNumber]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotNumber = partition(array, start, end);
            quickSort(array, start, pivotNumber - 1);
            quickSort(array, pivotNumber + 1, end);
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
