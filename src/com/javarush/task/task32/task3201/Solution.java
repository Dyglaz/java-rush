package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile raf = new RandomAccessFile(args[0], "w")) {
            if(Integer.parseInt(args[1]) > raf.length()) {
                raf.seek(raf.length());
                raf.write(args[2].getBytes());
            } else {
                raf.seek(Integer.parseInt(args[1]));
                raf.write(args[2].getBytes());
            }
        } catch (IOException e) {
        }
    }
}
