package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream firstFileInput = new FileInputStream(args[0])){

            byte[] buffer = new byte[firstFileInput.available()];
            long countCharacters = firstFileInput.read(buffer);
            List<Byte> list = new ArrayList<>();
            for (byte b : buffer) {
                list.add(b);
            }
            long countWhitespace = list.stream().filter(i -> (i == 32)).count();
            System.out.println(new BigDecimal((double) countWhitespace / countCharacters * 100).setScale(2, RoundingMode.HALF_UP));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
