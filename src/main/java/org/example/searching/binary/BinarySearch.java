package org.example.searching.binary;

public class BinarySearch {

    public static int search(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;

        while (start <= middle) {
            System.out.println(start + " " + end + " " + middle);

            if (value < arr[middle]) {
                end = middle - 1;
            } else if (value > arr[middle]) {
                start = middle + 1;
            } else {
                System.out.println("Found at Index " + middle);
                return middle;
            }
            middle = (start + end) / 2;
        }

        System.out.println(start + " " + end + " " + middle);
        System.out.println("Element Not found");

        return -1;
    }

}
