package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        String input = "AAABABB";

        var result = solution(12);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int area) {
        // Your code here
        List<Integer> arr = new ArrayList<>();
        while (area > 0) {
            int max = maxSquare(area, 1, 1000);
            area -= max;
            arr.add(max);
        }
        int[] res = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            res[i] = arr.get(i);
        }
        return res;
    }

    public static int maxSquare(int number, int start, int end) {
        int mid =  (start+end) / 2;
        int mid2 = mid * mid;

        if (end - start == 1 || start - end == 1) {
            if ((mid+1)*(mid+1) <= number)
                return (mid+1)*(mid+1);
            else
                return mid2;
        } else {
            if (mid2 < number)
                return maxSquare(number, mid, end);
            else if (mid2 > number)
                return maxSquare(number, start, mid);
            else if (mid2 == number) {
                return mid2;
            }
        }

        return 0;
    }

}