package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        final double mediana = getMediana(array);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - mediana;
                double v2 = o2.intValue() - mediana;
                return (int) ((v1*v1 - v2*v2) * 100);
            }
        });
        return array;
    }

    public static double getMediana(Integer[] array) {
        Arrays.sort(array);

        if (array.length % 2 == 0) {
            int rightInt = array[array.length / 2];
            int leftInt = array[array.length / 2 - 1];
            return (rightInt + leftInt) / 2.0;
        } else {
            return array[array.length / 2];
        }
    }
}
