package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            FileOutputStream outputStream = new FileOutputStream(reader.readLine())){

            byte[] buffer = new byte [inputStream.available()];
            byte[] newBuffer = new byte [inputStream.available()];
            int count = inputStream.read(buffer);
            int j = 0;
            for (int i = buffer.length - 1; i >= 0; i--) {
                newBuffer[i] = buffer[j];
                j++;
            }
            outputStream.write(newBuffer, 0, count);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
