package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Мак", 1.0);
        grades.put("Гоха", 2.0);
        grades.put("Ден", 3.0);
        grades.put("Лиза", 4.0);
        grades.put("Владимир", 5.0);
    }
}