package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        strings = new String[6];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = scan.nextLine();
        }

        for (int i = 0; i < strings.length; i++) {
            if(strings[i]==null) continue;
            String word = strings[i];
            boolean clear = false;
            for (int j = 0; j < strings.length; j++) {
                if(i==j) continue;
                if (strings[j]!=null && word.equals(strings[j])) {
                    clear=true;
                    strings[j] = null;
                }
                if(clear){
                    strings[i] = null;
                }
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
