package com.javarush.task.task35.task3502;

import java.awt.*;/*
Знакомство с дженериками
*/
import java.util.List;

public class Solution<T extends List<Solution.SomeClass>> {
    public static class SomeClass<K extends Number> {
    }

    public static void main(String[] args) {

    }
}
