package org.example.yandex.intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[][] arr = new int[count][2];
        for (int[] ar: arr) {
            String[] input = reader.readLine().split(" ");
            ar[0] = Integer.parseInt(input[0]);
            ar[1] = Integer.parseInt(input[1]);
        }
        int[] res = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            if (res[i] == -1) continue;

            int[] point1 = arr[i];
            boolean notFound = true;
            for (int j=i+1; j<arr.length; j++) {
                int[] point2 = arr[j];
                if (point1[0] == point2[0] || point1[1] == point2[1]) {
                    notFound = false;
                    res[j] = -1;
                }
                if (point1[0] < point2[0] && point1[1] > point2[1]) {
                    notFound = false;
                    res[j] = -1;
                }
                if (point1[0] > point2[0] && point1[1] < point2[1]) {
                    notFound = false;
                    res[j] = -1;
                }
            }
            if (!notFound) {
                res[i] = -1;
            }
        }
        int c = 0;
        for (int num : res) {
            if (num == 0) {
                c++;
            }
        }
        System.out.println(c);
    }
}
