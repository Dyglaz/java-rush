package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        if (N > 0) {
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = input.nextInt();
            }
            if (N % 2 != 0) {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }

            } else {
                for (int i = N-1; i >= 0 ; i--) {
                    System.out.println(array[i]);
                }
            }

        }

    }
}
