package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             InputStream inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))) {
            int tmpByte = 0, tmpCount = 1;
            while (inputStream.available() > 0) {
                if (tmpCount % 2 != 0) {
                    tmpCount++;
                    tmpByte = inputStream.read();
                } else {
                    outputStream.write(inputStream.read());
                    outputStream.write(tmpByte);
                    tmpByte = 0;
                    tmpCount++;
                }
            }
            if (tmpCount % 2 == 0) {
                outputStream.write(tmpByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

