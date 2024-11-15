package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Set<Integer> set = new HashSet<>();
        int byteFile;

        while (fis.available() > 0)
        {
            byteFile = fis.read();
            set.add(byteFile);
        }

        String listString = set
                .stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(listString);

        reader.close();
        fis.close();
    }
}
