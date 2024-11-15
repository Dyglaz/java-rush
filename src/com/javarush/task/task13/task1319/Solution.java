package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.*;
/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(System.in);
            FileWriter fileInputStream = new FileWriter(scanner.nextLine());
            BufferedWriter inStream = new BufferedWriter(fileInputStream)) {
            List<String> list = new ArrayList<>();
            String str;
            while (true) {
                str = scanner.nextLine();
                list.add(str);
                if(str.equals("exit")) break;
            }
            list.forEach((n) -> {
                try {
                    inStream.write(n);
                    inStream.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
