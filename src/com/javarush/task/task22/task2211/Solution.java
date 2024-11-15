package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new InputStreamReader(new FileInputStream(args[0]), "Windows-1251");
             Writer writer = new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8)) {

            char[] buffer = new char[1024];
            int bytesRead;

            // Читаем данные из входного файла и записываем в выходной файл
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

