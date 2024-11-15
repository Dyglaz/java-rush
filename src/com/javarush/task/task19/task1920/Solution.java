package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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

            double max = lines.values().stream().max(Double::compareTo).get();

            List<Map.Entry<String, Double>> sortedEntries = new ArrayList<>(lines.entrySet());
            sortedEntries.sort(Map.Entry.comparingByKey());

            for (Map.Entry<String, Double> entry : sortedEntries) {
                if(entry.getValue() == max){
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
