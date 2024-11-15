package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()));
             PrintWriter printWriter = new PrintWriter(new FileWriter(reader.readLine()))) {

            while(bufferedFileReader.ready()) {
                String[] numbsDouble = bufferedFileReader.readLine().split(" ");
                for(String numbDouble : numbsDouble ){
                    double numbDoubleDouble = Double.parseDouble(numbDouble);
                    printWriter.print(Math.round(numbDoubleDouble) + " ");
                }

            }
        }
    }

}
