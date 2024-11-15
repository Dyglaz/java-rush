package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream firstFileInput = new FileInputStream(reader.readLine());
            FileOutputStream secondFileOutput = new FileOutputStream(reader.readLine());
            FileOutputStream thirdFileOutput = new FileOutputStream(reader.readLine())){

            byte[] buffer = new byte[firstFileInput.available()];
            int count = firstFileInput.read(buffer);
            if(count % 2 == 0){
                secondFileOutput.write(buffer, 0, count / 2);
                thirdFileOutput.write(buffer, count / 2, count / 2);
            } else {
                secondFileOutput.write(buffer, 0, count / 2 + 1);
                thirdFileOutput.write(buffer, count / 2 + 1, buffer.length - (count / 2 + 1));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
