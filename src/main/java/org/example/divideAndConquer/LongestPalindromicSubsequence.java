package org.example.divideAndConquer;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "elrmenmet";

        System.out.println(findLPSLength(str));
    }

    public static int findLPSLength(String str) {
        return findLPSLength(str, 0, str.length() - 1);
    }

    private static int findLPSLength(String str, int startIndex, int endIndex) {
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;

        int count1 = 0;
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            count1 = 2+ findLPSLength(str, startIndex + 1, endIndex - 1);
        }
        int count2 = findLPSLength(str, startIndex + 1, endIndex);
        int count3 = findLPSLength(str, startIndex, endIndex - 1);

        return Math.max(count1, Math.max(count2, count3));
    }

}
