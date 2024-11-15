package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            String strNumber = args[0];
            for (int i = 2; i <= 36; i++) {
                try {
                    new BigInteger(strNumber, i);
                    System.out.println(i);
                    return;
                } catch (NumberFormatException e) {
                }
            }
            System.out.println("incorrect");
        } catch (Exception e) {
        }
    }
}