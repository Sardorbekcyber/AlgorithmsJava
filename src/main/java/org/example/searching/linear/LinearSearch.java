package org.example.searching.linear;

public class LinearSearch {

    public static int search(int[] arr, int value) {
        for (int i=0; i<arr.length; i++) {
            if (value == arr[i]){
                System.out.println("Element found at index " + i);
                return i;
            }
        }
        System.out.println("Element was not found in array");
        return -1;
    }

}
