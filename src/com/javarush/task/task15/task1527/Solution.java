package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] parts = url.split("\\?", 2); // Разбиваем по символу '?', чтобы получить часть после него

        if (parts.length > 1) {
            // Разбиваем часть после '?' по символу '&'
            String[] params = parts[1].split("&");
            String[] tmp = parts[1].split("&");
            String num = "";

            for (int i = 0; i < params.length; i++) {
                int index = params[i].indexOf("=");
                int index_2 = params[i].indexOf("obj");

                String result = "";
                if(index != -1){
                    tmp[i] = params[i].substring(0, index);
                }
                if(index_2 != -1) num = params[i].substring(index_2 + 4);
            }
            String result = String.join(" ", tmp);
            System.out.println(result);

            if(!num.isEmpty()){
                try{
                    alert(Double.parseDouble(num));
                } catch (NumberFormatException e){
                    alert(num);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
