package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        if (decimalNumber > 0) {
            int octNum = 0, i = 0;
            while (decimalNumber != 0) {
                octNum = octNum + (decimalNumber % 8) * (int) (Math.pow(10, i));
                decimalNumber /= 8;
                i++;
            }
            return octNum;
        } else {
            return 0;
        }
    }

    public static int toDecimal(int octalNumber) {
        if (octalNumber > 0) {
            int decNum = 0, i = 0;
            while (octalNumber != 0) {
                decNum = decNum + (octalNumber % 10) * (int) (Math.pow(8, i));
                octalNumber /= 10;
                i++;
            }
            return decNum;
        } else {
            return 0;
        }
    }
}
