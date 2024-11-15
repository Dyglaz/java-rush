package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName, newFile = null;
            List<String> filesName = new ArrayList<>();
            while(!(fileName = reader.readLine()).equals("end")){
                filesName.add(fileName);
                if(newFile == null){
                    newFile = fileName.substring(0, fileName.lastIndexOf(".part"));
                }
            }

            filesName.sort((o1, o2) -> {
                int num = Integer.parseInt(o1.replaceAll("\\D+", ""));
                int num2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
                return Integer.compare(num, num2);
            });

            try(FileOutputStream fileOutputStream = new FileOutputStream(newFile)){
                for(String s : filesName){
                    try(FileInputStream fileInputStream = new FileInputStream(s)){
                        byte[] bytes = new byte[fileInputStream.available()];
                        int countBytes = fileInputStream.read(bytes);
                        fileOutputStream.write(bytes, 0, countBytes);
                    }
                }
            }
        }
    }
}
