package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            Map<String, Double> lines = new HashMap<>();
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                lines.put(strings[0], lines.getOrDefault(strings[0], 0.0) + Double.parseDouble(strings[1]));
            }
            reader.close();

            List<Map.Entry<String, Double>> sortedEntries = new ArrayList<>(lines.entrySet());
            sortedEntries.sort(Map.Entry.comparingByKey());

            for (Map.Entry<String, Double> entry : sortedEntries) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}

