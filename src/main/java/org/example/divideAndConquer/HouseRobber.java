package org.example.divideAndConquer;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {6, 7, 1, 30, 8, 2, 4};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.maxMoney(houses));
    }

    public int maxMoney(int[] houseNetWorth) {
        return maxMoneyRecursive(houseNetWorth, 0);
    }

    private int maxMoneyRecursive(int[] houseNetWorth, int currentIndex) {
        if (currentIndex >= houseNetWorth.length) {
            return 0;
        }

        int stealCurrentHouse = houseNetWorth[currentIndex] + maxMoneyRecursive(houseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maxMoneyRecursive(houseNetWorth, currentIndex + 1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }
}
