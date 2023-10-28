package org.example.sorting.bucket;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\nBucket:#" + i + ":");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }

    public void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil((float) value * numberOfBuckets / (float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("\n\nPrinting Buckets before sorting");
        printBucket(buckets);

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting Buckets after sorting");
        printBucket(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }

    void printArray(int[] arr) {
        System.out.println();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
