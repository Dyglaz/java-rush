package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))) {
            String line;
            StringBuilder endLine = new StringBuilder();
            while((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(" ");
                for(String s : lines) {
                    if(s.length() > 6) {
                        endLine.append(s + " ");
                    }
                }
            }
            bufferedWriter.write(endLine.toString().trim().replaceAll(" ", ","));
        }
    }
}
