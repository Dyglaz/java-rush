package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strObj = reader.readLine();
        int strNum = 0;
        if(strObj.equals("helicopter")){
            result = new Helicopter();
        } else if(strObj.equals("plane")){
            strNum = reader.read();
            result = new Plane(strNum);
        }
        reader.close();
    }
}
