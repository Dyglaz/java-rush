package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min(int a, int b){
        return Math.min(a, b);
    }
    public static int min(int a, int b, int c){
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
    public static int min(int a, int b, int c, int d){
        int min = Math.min(a, b);
        int min2 = Math.min(c, d);
        return Math.min(min2, min);
    }
    public static int min(int a, int b, int c, int d, int e){
        int min = Math.min(a, b);
        int min2 = Math.min(c, d);
        int min3 = Math.min(min2, min);
        return Math.min(min3, e);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }
    public static int max(int a, int b, int c){
        int min = Math.max(a, b);
        return Math.max(min, c);
    }
    public static int max(int a, int b, int c, int d){
        int min = Math.max(a, b);
        int min2 = Math.max(c, d);
        return Math.max(min2, min);
    }
    public static int max(int a, int b, int c, int d, int e){
        int min = Math.max(a, b);
        int min2 = Math.max(c, d);
        int min3 = Math.max(min2, min);
        return Math.max(min3, e);
    }


}
