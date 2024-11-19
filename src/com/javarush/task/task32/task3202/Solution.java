package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            if(is.available() == 0) return writer;
            byte[] inputData = new byte[is.available()];
            is.read(inputData, 0 , inputData.length);
            writer.write(new String(inputData, StandardCharsets.UTF_8));
        }
        return writer;
    }
}
