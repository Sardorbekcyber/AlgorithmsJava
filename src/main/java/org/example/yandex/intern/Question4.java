package org.example.yandex.intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String realLine = reader.readLine();

        char[] line = realLine.toCharArray();
        HashSet<Integer> pos = new HashSet<>();
        for (int i = 0; i < realLine.length(); i++) {
            char ch = realLine.charAt(i);

            if (ch == 'R') {
                line[i] = 'F';
                pos.add(move(line));
                line[i] = 'L';
                pos.add(move(line));
                line[i] = 'R';
            } else if (ch == 'F') {
                line[i] = 'R';
                pos.add(move(line));
                line[i] = 'L';
                pos.add(move(line));
                line[i] = 'F';
            } else {
                line[i] = 'R';
                pos.add(move(line));
                line[i] = 'F';
                pos.add(move(line));
                line[i] = 'L';
            }
        }

        System.out.println(pos.size());
    }

    public static int move(char[] path) {
        int start = 0;
        char op = 'R';
        for (char p : path) {
            if (p == 'F') {
                if (op == 'R') {
                    start++;
                } else {
                    start--;
                }
            } else {
                op = p;
            }
        }
        return start;
    }
}
