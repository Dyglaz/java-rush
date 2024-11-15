package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner (new FileInputStream(String.valueOf(new Scanner(System.in).nextLine())));
        Integer i;
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        list.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(System.out::println);
        scanner.close();
    }
}
