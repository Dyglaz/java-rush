package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String firstFile  = reader.readLine();
            String secondFile = reader.readLine();
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secondFile))){
                while(bufferedReader.ready()){
                    String[] strings = bufferedReader.readLine().split(" ");
                    for(String string : strings){
                        try{
                            int intStr = Integer.parseInt(string);
                            bufferedWriter.write(String.valueOf(intStr) + " ");
                        } catch (NumberFormatException e){
                        }
                    }
                }
            }
        }
    }
}
