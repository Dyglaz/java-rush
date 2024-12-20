package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        while(!(tmp = reader.readLine()).equals("exit")){
            try{
                if(tmp.contains(".")) print(Double.parseDouble(tmp));
                else {
                    int count = Integer.parseInt(tmp);
                    if(count > 0 && count < 128) print((short) count);
                    else if(count <=0 || count >= 128) print(count);
                }
            } catch (Exception e) {
                print(tmp);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
