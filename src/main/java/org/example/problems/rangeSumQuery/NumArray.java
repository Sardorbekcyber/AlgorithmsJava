package org.example.problems.rangeSumQuery;

public class NumArray {
    public int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        int sumOfAll = prefixSum[right];
        int leftSum;
        if (left <= 0) {
            leftSum = 0;
        } else {
            leftSum = prefixSum[left - 1];
        }

        return sumOfAll - leftSum;
    }

    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(a);
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }

}
