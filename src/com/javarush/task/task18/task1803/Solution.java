package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<>();
        int byteFile;

        while (fis.available() > 0)
        {
            byteFile = fis.read();
            if(!map.containsKey(byteFile)){
                map.put(byteFile, 1);
            } else {
                map.put(byteFile, map.get(byteFile) + 1);
            }
        }

        Optional<Integer> maxValue = map.values().stream().max(Integer::compareTo);
        int max = maxValue.get();
        StringJoiner sj = new StringJoiner(" ");

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                sj.add(entry.getKey().toString());
            }
        }

        System.out.println(sj);
        reader.close();
        fis.close();
    }
}
