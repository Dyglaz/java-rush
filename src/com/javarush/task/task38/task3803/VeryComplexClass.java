package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new Object();
        String str = (String) obj;
    }

    public void methodThrowsNullPointerException() {
        String str = null;
        int length = str.length();
    }

    public static void main(String[] args) {

    }
}
