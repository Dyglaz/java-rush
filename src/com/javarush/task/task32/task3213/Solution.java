package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder result = new StringBuilder();
        int num;
        if (reader != null) {
            while ((num = reader.read()) != -1) {
                result.append((char) (num + key));
            }
        }
        return result.toString();
    }
}
