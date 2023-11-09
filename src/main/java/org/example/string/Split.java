package org.example.string;

import java.util.*;

public class Split {

    public static void main(String[] args) {
        String phrase = "dog cat cat dog";

        String[] words = phrase.split(" ");
        System.out.println(Arrays.toString(words));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) {
                if (!set.contains(word)) {
                    return false;
                }
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (set.add(word)) {
                    map.put(ch, word);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
