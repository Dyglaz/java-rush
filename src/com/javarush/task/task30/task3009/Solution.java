package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        int decNumber;
        try {
            decNumber = Integer.parseInt(number, 10);
        } catch (NumberFormatException e) {
            return set;
        }
        outerLoop:
        for (int i = 2; i <= 36; i++) {
            String newNumber = Integer.toString(decNumber, i);
            char[] chars = newNumber.toCharArray();
            for (int j = 0, k = chars.length - 1; j < chars.length; j++, k--) {
                if (chars[j] != chars[k]) {
                    continue outerLoop;
                }
            }
            set.add(i);
        }
        return set;
    }
}