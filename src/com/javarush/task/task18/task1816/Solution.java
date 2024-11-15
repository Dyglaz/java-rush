package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream firstFileInput = new FileInputStream(args[0])){

            byte[] buffer = new byte[firstFileInput.available()];
            firstFileInput.read(buffer);
            List<Byte> list = new ArrayList<>();
            for (byte b : buffer) {
                list.add(b);
            }
            System.out.println(list.stream().filter(i -> (i >= 65 && i <= 90) || (i >= 97 && i <= 122)).count());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
