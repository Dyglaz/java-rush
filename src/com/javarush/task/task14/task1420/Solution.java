package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = Math.min(a,b); i > 0; i--) {
            if(a % i == 0 && b % i == 0){
                System.out.println(i);
                break;
            }
        }
    }
}
