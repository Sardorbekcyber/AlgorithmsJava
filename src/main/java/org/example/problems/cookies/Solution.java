package org.example.problems.cookies;

public class Solution {

    public static void main(String[] args) {
        int[] child = new int[]{1, 2, 3};
        int[] cookies = new int[]{1, 1};

        findContentChildren(child, cookies);
    }

    public static int findContentChildren(int[] g, int[] s) {
        mergeSort(s, 0, s.length-1);
        mergeSort(g, 0, g.length-1);

        int cookieIndex = 0;
        int childIndex = 0;

        while (cookieIndex < s.length && childIndex < g.length) {
            int cookie = s[cookieIndex];
            int child = g[childIndex];
            if (cookie >= child) {
                childIndex++;
                cookieIndex++;
            } else {
                cookieIndex++;
            }
        }

        return 1 + cookieIndex;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int m = (left + right) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }

    static void merge(int[] A, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle - left + 2];
        int[] rightTmpArray = new int[right - middle + 1];
        for (int i = 0; i <= middle - left; i++) {
            leftTmpArray[i] = A[left + i];
        }
        for (int i = 0; i < right - middle; i++) {
            rightTmpArray[i] = A[middle + 1 + i];
        }

        leftTmpArray[middle - left + 1] = Integer.MAX_VALUE;
        rightTmpArray[right - middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }

        }
    }
}
