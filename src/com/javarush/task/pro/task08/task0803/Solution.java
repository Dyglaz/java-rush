package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        int minInt = Integer.MAX_VALUE;
        for (int anInt : ints) {
            minInt = Math.min(minInt, anInt);
        }
        return minInt;
    }

    public static int[] getArrayOfTenElements() {
        Scanner scan = new Scanner(System.in);
        int[] intArray = new int[10];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scan.nextInt();
        }
        return intArray;
    }
}
