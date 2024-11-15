package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }


//    public static void main(String[] args) throws IOException {
//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/TestJava/Input.txt"))){
//            String line;
//            while((line = bufferedReader.readLine()) != null) {
//                String[] lines = line.split(" ");
//                System.out.println(Arrays.stream(lines)
//                        .map(s -> map.getOrDefault(Integer.parseInt(s), s))
//                        .collect(Collectors.joining(" ")));
//            }
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/TestJava/Input.txt"))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] lines = line.split(" ");
//                StringBuilder stringBuilder = new StringBuilder();
//                for (String s : lines) {
//                    try {
//                        int number = Integer.parseInt(s);
//                        stringBuilder.append(map.getOrDefault(number, s)).append(" ");
//                    } catch (NumberFormatException e) {
//                        stringBuilder.append(s).append(" ");
//                    }
//                }
//                System.out.println(stringBuilder.toString().trim());
//            }
//        }
//    }

    public static void main(String[] args) {
        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ignore) {

        }

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((fileLine = in.readLine()) != null) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
                }
                System.out.println(fileLine);
            }
        } catch (IOException ignore) {

        }
    }

}

