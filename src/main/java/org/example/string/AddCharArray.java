package org.example.string;

public class AddCharArray {

    public static void main(String[] args) {
        String a = "11";
        String b = "123";

        String res = addStrings(a, b);

        System.out.println(res);
    }

    public static String addStrings(String num1, String num2) {
        int mem = 0;
        StringBuilder str = new StringBuilder();
        int maxSize = Math.max(num1.length(), num2.length());
        char[] min = new char[maxSize];
        char[] max = new char[maxSize];
        for (int i=maxSize-1, index = num1.length()-1; i>=0 && index >=0; i--, index--) {
            max[i] = num1.charAt(index);
        }
        for (int i=maxSize-1, index = num2.length()-1; i>=0 && index >=0; i--, index--) {
            min[i] = num2.charAt(index);
        }
        for (int i=maxSize-1; i>=0; i--) {
            int a = Character.getNumericValue(min[i]);
            int b = Character.getNumericValue(max[i]);
            int all = (a + b + mem);
            int add = all % 10;
            mem = all > 10 ? 1 : 0;
            str.append(add);
        }
        if (mem > 0) {
            str.append(mem);
        }
        return str.reverse().toString();
    }

}
