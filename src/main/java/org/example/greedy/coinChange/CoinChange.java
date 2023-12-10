package org.example.greedy.coinChange;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 1000};

        int amount = 2035;

        System.out.println(Arrays.toString(coins));
        System.out.println("Target Amount " + amount);
        coinChange(coins, amount);
    }

    static void coinChange(int[] coins, int N) {
        Arrays.sort(coins);

        int index = coins.length - 1;
        while (true) {
            int coinValue = coins[index];
            index--;

            int maxAmount = (N / coinValue) * coinValue;
            if (maxAmount > 0) {
                System.out.println("Count Value " + coinValue + " taken count: " + N / coinValue);
                N = N - maxAmount;
            }
            if (N == 0) {
                break;
            }
        }
    }

}
