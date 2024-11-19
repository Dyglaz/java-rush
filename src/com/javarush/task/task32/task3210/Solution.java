package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            byte[] bytes = new byte[args[2].length()];
            raf.seek(Long.parseLong(args[1]));
            raf.read(bytes, 0, args[2].length());
            String textRead = new String(bytes);
            raf.seek(raf.length());
            if(textRead.equals(args[2])) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }

        } catch (Exception e) {
        }
    }
}
