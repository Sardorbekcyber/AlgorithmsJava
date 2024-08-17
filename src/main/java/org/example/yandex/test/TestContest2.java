package org.example.yandex.test;

import java.io.*;

public class TestContest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        String[] line = in.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        FileWriter myWriter = new FileWriter("output.txt");
        myWriter.write(String.valueOf(a + b));
        myWriter.close();
    }
}
