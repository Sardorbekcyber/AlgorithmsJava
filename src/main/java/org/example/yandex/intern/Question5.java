package org.example.yandex.intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] counts = reader.readLine().split(" ");
        int wordCount = Integer.parseInt(counts[0]);
        int questionsCount = Integer.parseInt(counts[1]);

        ArrayList<Word> list = new ArrayList<>();

        for (int i = 0; i < wordCount; i++) {
            String[] values = reader.readLine().split(" ");
            Word word = new Word();
            word.pri = Integer.parseInt(values[1]);
            word.word = values[0];
            word.index = i + 1;
            list.add(word);
        }
        StringBuilder search = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < questionsCount; j++) {
            String[] op = reader.readLine().split(" ");
            if (op[0].equals("+")) {
                search.append(op[1]);
            } else {
                search.deleteCharAt(search.length() - 1);
            }
            Collections.sort(list);

            for (Word word: list) {
                if (word.word.startsWith(search.toString())) {
                    if (!result.isEmpty()) {
                        result.append("\n");
                    }
                    result.append(word.index);
                    break;
                }
            }
        }

        System.out.println(result);
    }
}

class Word implements Comparable<Word> {
    String word;
    int pri;
    int index;

    public Word() {
    }

    @Override
    public int compareTo(Word o) {
        return o.pri-pri;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", pri=" + pri +
                ", index=" + index +
                '}';
    }
}