package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(System.in)) {
            List<String> listStr = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (int i = 0; i < listStr.size(); i+=2) {
                System.out.println(listStr.get(i));
            }
        }
    }
}

