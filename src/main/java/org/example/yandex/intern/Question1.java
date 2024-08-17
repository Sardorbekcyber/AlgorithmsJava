package org.example.yandex.intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine() + " ";
        int max = 0;
        StringBuilder str = new StringBuilder();
        ArrayDeque<String> words = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            if (ch == ',') {
                max = Math.max(str.length(), max);
                if (str.isEmpty()) {
                    words.add(words.pollLast() + ch);
                } else {
                    str.append(ch);
                    words.add(str.toString());
                    str.setLength(0);
                }
            } else if (ch == ' ') {
                if (str.isEmpty()) continue;

                max = Math.max(str.length(), max);
                words.add(str.toString());
                str.setLength(0);
            } else {
                str.append(ch);
            }
        }

        max = Math.max(str.length(), max);

        int lineMaxLen = max * 3;

        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        while (!words.isEmpty()) {
            String word = words.poll();
            int wLen = word.length();
            if (line.length() + wLen + 1 > lineMaxLen) {
                if (!result.isEmpty()) {
                    result.append("\n");
                }
                result.append(line);
                line.setLength(0);
                line.append(word);
            } else {
                if (!line.isEmpty()) {
                    line.append(" ");
                }
                line.append(word);
            }
        }
        if (!line.isEmpty()) {
            result.append("\n");
            result.append(line);
            line.setLength(0);
        }

        System.out.println(result);
    }
}

