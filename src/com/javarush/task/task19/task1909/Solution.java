package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String firstFile = reader.readLine();
            String secondFile = reader.readLine();
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secondFile))){
                while (bufferedReader.ready()){
                    bufferedWriter.write(bufferedReader.readLine().replaceAll("\\.", "!"));
                }
            }
        }
    }
}