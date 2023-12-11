package org.example.divideAndConquer;

public class NumberFactor {

    public static void main(String[] args) {
        NumberFactor numberFactor = new NumberFactor();

        System.out.println(numberFactor.waysToGetN(4));
        System.out.println(numberFactor.waysToGetN(5));
        System.out.println(numberFactor.waysToGetN(6));
    }

    public int waysToGetN(int n) {
        if (n == 0 || n == 1 || n == 2) return 1;
        if (n == 3) return 2;

        int sub1 = waysToGetN(n - 1);
        int sub2 = waysToGetN(n - 3);
        int sub3 = waysToGetN(n - 4);

        return sub1 + sub2 + sub3;
    }
}
