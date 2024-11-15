package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Считаем слово
*/

public class Solution {
    private static Set<Character> vowels = new HashSet<>();

    static{
        vowels.add('!');
        vowels.add('"');
        vowels.add('#');
        vowels.add('$');
        vowels.add('%');
        vowels.add('&');
        vowels.add('\'');
        vowels.add('(');
        vowels.add(')');
        vowels.add('*');
        vowels.add('+');
        vowels.add(',');
        vowels.add('-');
        vowels.add('.');
        vowels.add('/');
        vowels.add(':');
        vowels.add('<');
        vowels.add('?');
        vowels.add('@');
        vowels.add('[');
        vowels.add('\\');
        vowels.add(']');
        vowels.add('^');
        vowels.add('_');
        vowels.add('`');
        vowels.add('{');
        vowels.add('}');
        vowels.add('~');
    }

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(reader.readLine())){

            int count = 0;
            StringBuilder word = new StringBuilder();
            while(fileReader.ready()){
                char character = (char) fileReader.read();
                if(Character.isLetter(character)){
                    word.append(character);
                } else {
                    if (word.toString().equalsIgnoreCase("world")) {
                        count++;
                    }
                    word.setLength(0);
                }
            }
            System.out.println(count);
        }
    }
}
