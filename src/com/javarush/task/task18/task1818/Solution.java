package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream firstFileOutput = new FileOutputStream(reader.readLine());
            FileInputStream secondFileInput = new FileInputStream(reader.readLine());
            FileInputStream thirdFileInput = new FileInputStream(reader.readLine())) {

            byte[] buffer = new byte[secondFileInput.available()];
            int count = secondFileInput.read(buffer);
            firstFileOutput.write(buffer, 0, count);

            buffer = new byte[thirdFileInput.available()];
            count = thirdFileInput.read(buffer);
            firstFileOutput.write(buffer, 0, count);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
