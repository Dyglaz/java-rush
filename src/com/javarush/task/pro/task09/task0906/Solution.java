package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {

        String binaryRepresentation = "";
        if (decimalNumber > 0) {
            while (decimalNumber != 0) {
                binaryRepresentation = (decimalNumber % 2) + binaryRepresentation;
                decimalNumber /= 2;
            }
            return binaryRepresentation;
        }
        else {
                return "";
        }

    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber != null && !binaryNumber.isEmpty() ) {
            int decNum = 0;
            for (int i = 0; i < binaryNumber.length(); i++) {
                decNum = decNum + (binaryNumber.charAt(binaryNumber.length() - 1 - i) - '0') * (int) (Math.pow(2, i));
            }
            return decNum;

        } else {
            return 0;
        }
    }
}
