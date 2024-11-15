package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null || string.isEmpty()) throw new TooShortStringException();

        String[] parts = string.split(" ");
        if(5 > parts.length) throw new TooShortStringException();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            sb.append(parts[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
