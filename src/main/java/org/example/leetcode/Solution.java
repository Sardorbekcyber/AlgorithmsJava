package org.example.leetcode;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        var input = "(()())(())";
        var res = removeOuterParentheses(input);

        System.out.println(res);
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (ch == ')' && stack.size() == 1) {
                if (cur.length() > 1) {
                    res.append(cur.substring(1));
                }
                cur.setLength(0);
                stack = new Stack<>();
            } else if (ch == ')') {
                cur.insert(0, stack.pop());
                cur.append(ch);
            } else {
                stack.push(ch);
            }
        }

        return res.toString();
    }

}
