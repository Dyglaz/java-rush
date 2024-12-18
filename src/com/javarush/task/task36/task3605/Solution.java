package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> set = new TreeSet<>();

        String s;
        while ((s = reader.readLine()) != null) {
            for (char c : s.toLowerCase().toCharArray()) {
                if(c >= 97 && c <= 122) {
                    set.add(c);
                }
            }
        }

        reader.close();

        int count = 0;
        for (Character c : set) {
            System.out.print(c);
            count++;
            if(count == 5){
                break;
            }
        }
    }
}
