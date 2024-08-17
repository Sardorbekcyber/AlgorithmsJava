package org.example.yandex.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TestContest1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] input = new String[count];
        for (int i = 0; i < count; i++) {
            try {
                input[i] = reader.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String inp : input) {
            String[] details = inp.split(",");
            HashSet<Character> characters = new HashSet<>();

            for (int i = 0; i <= 2; i++) {
                String word = details[i];
                for (char ch : word.toCharArray()) {
                    characters.add(ch);
                }
            }
            int digits = 0;

            for (int j = 3; j <= 4; j++) {
                String date = details[j];
                for (char d : date.toCharArray()) {
                    digits += Character.getNumericValue(d);
                }
            }

            int lastNameAlp = Character.toLowerCase(details[0].charAt(0)) - 'a' + 1;

            int sum = characters.size() + digits * 64 + lastNameAlp * 256;

            if (!res.isEmpty()) {
                res.append(" ");
            }

            String hex = Integer.toHexString(sum).toUpperCase();
            int len = hex.length();
            if (len >= 3) {
                res.append(hex.substring(len - 3));
            } else {
                int c = 3 - len;
                while (c > 0) {
                    res.append('0');
                    c--;
                }
                res.append(hex);
            }
        }

        System.out.println(res);
    }
}
