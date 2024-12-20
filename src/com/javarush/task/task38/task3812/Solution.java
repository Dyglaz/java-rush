package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        try {
            printFullyQualifiedNames(Solution.class);
            printFullyQualifiedNames(SomeTest.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        try {
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String fullyQualifiedNames : prepareMyTest.fullyQualifiedNames()) {
                System.out.println(fullyQualifiedNames);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean printValues(Class c) {
        try {
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class value : prepareMyTest.value()) {
                System.out.println(value.getSimpleName());
            }
        } catch (Exception e) {
            return false;
        }
        return true;



    }
}
