package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try(Scanner scanner = new Scanner(System.in);
            FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
            BufferedReader inStream = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line;
            while ((line = inStream.readLine()) != null) {
                System.out.println(line);
            }

        }

    }
}