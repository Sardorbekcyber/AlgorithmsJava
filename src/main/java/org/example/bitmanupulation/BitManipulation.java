package org.example.bitmanupulation;

public class BitManipulation {

    public static void main(String[] args) {
        int number = 11948;
        String result = Integer.toString(number, 16);
        System.out.println(result);

        int a = 4;
        int b = -4;
        int c = ~a;
        int d = ~b;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        printBinary(a);
        printBinary(b);
        printBinary(c);
        printBinary(d);
    }

    //Printing the binary representation of any Number.
    static void printBinary(int num) {
        for (int i = 10; i >= 0; i--) System.out.print((num >> i) & 1);
        System.out.println();
    }

    //checking if the ith bit is set or not.
    static void voidCheckIfSet(int num, int i) {
        if ((num & (1 << i)) != 0) {
            System.out.println("Set");
        } else {
            System.out.println("Not Set");
        }
    }

    //Counting the number of set bits
    static int countOfSetBits(int num) {
        int count = 0;
        for (int i = 31; i >= 0; --i)
            if ((num & (1 << i)) != 0) count++;
        return count;
    }

    // Function to check if x is power of 2
    static boolean isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                cnt++; // if n&1 == 1 keep incrementing cnt
                // variable
            }
            n = n >> 1; // keep dividing n by 2 using right
            // shift operator
        }
        if (cnt == 1) {
            // if cnt = 1 only then it is power of 2
            return true;
        }
        return false;
    }

    static boolean isPowerOf2(int x) {
        /* First x in the below expression is
          for the case when x is 0 */
        return x != 0 && ((x & (x - 1)) == 0);
    }

    

}
