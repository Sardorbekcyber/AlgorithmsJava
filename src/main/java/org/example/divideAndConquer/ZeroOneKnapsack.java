package org.example.divideAndConquer;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] profits = {31, 26, 17, 72};
        int[] weights = {3, 1, 2, 5};
        int capacity = 7;

        System.out.println(knapsack(profits, weights, capacity));
    }

    public static int knapsack(int[] profits, int[] weights, int capacity) {
        return knapsack(profits, weights, capacity, 0);
    }

    private static int knapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }
        int profit2 = knapsack(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

}
