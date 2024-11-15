package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try(FileInputStream firstFileInput = new FileInputStream(firstFile);
        FileInputStream secondFileInput = new FileInputStream(secondFile)){
            while(secondFileInput.available()>0){
                byteArrayOutputStream.write(secondFileInput.read());
            }
            while(firstFileInput.available()>0){
                byteArrayOutputStream.write(firstFileInput.read());
            }

            FileOutputStream firstFileOutput = new FileOutputStream(firstFile);
            byteArrayOutputStream.writeTo(firstFileOutput);
            firstFileOutput.close();
        }

    }
}
