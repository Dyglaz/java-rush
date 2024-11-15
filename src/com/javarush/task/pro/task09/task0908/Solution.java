package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return "";
        }

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1') {
                return "";
            }
        }

        if (binaryNumber.length() % 4 != 0) {
            for (int i = 0; i < binaryNumber.length() % 4; i++) {
                binaryNumber = "0".concat(binaryNumber);
            }
        }

        String[] hexTable = {
                "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "a", "b", "c", "d", "e", "f"
        };

        StringBuilder hexStr = new StringBuilder();
        for (int i = 0; i < binaryNumber.length(); i += 4) {
            String fourBits = binaryNumber.substring(i, i + 4);
            int decimalValue = binaryToDecimal(fourBits);
            hexStr.append(hexTable[decimalValue]);
        }

        return hexStr.toString();

    }

    private static int binaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2;
        }

        return decimal;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.isEmpty()) {
            return "";
        }

        if (!hexNumber.matches("[0-9a-f]*")) {
            return "";
        }
        String[] hexTable = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001",
                "1010", "1011", "1100", "1101", "1110", "1111"
        };

        StringBuilder hexStr = new StringBuilder();
        for (int i = 0; i < hexNumber.length(); i++) {
            if (hexNumber.charAt(i) == 'a') {
                hexStr.append(hexTable[10]);
            } else if (hexNumber.charAt(i) == 'b') {
                hexStr.append(hexTable[11]);
            } else if (hexNumber.charAt(i) == 'c') {
                hexStr.append(hexTable[12]);
            } else if (hexNumber.charAt(i) == 'd') {
                hexStr.append(hexTable[13]);
            } else if (hexNumber.charAt(i) == 'e') {
                hexStr.append(hexTable[14]);
            } else if (hexNumber.charAt(i) == 'f') {
                hexStr.append(hexTable[15]);
            } else {
                hexStr.append(hexTable[(int) (hexNumber.charAt(i) - '0')]);
            }
        }

        return hexStr.toString();

    }
}
