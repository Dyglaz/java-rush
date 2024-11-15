package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String result = Arrays.stream(line.split(" "))
//                        .filter(s -> s.matches(".*[0-9].*"))
//                        .collect(Collectors.joining(" "));
//
//                if (!result.isEmpty()) {
//                    bufferedWriter.write(result);
//                }
//            }

            String fileReadLine;
            String[] splitedLine;
            while ((fileReadLine = bufferedReader.readLine()) != null) {
                splitedLine = fileReadLine.split(" ");
                for (String word : splitedLine) {
                    if (word.matches(".*\\d.*")) {
                        bufferedWriter.write(word + " ");
                    }
                }
            }
        }
    }
}
