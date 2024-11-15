package com.javarush.task.task25.task2512;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution extends Thread implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> strings = new ArrayList<>();
        while(e != null){
            strings.add(0, e.toString());
            e = e.getCause();
        }
        strings.forEach(System.out::println);
    }

    @Override
    public void run() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            // Обработка исключения, если необходимо
            uncaughtException(Thread.currentThread(), e); // Вызываем обработчик
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread threan = new Thread(solution);

        // Устанавливаем обработчик необработанных исключений
        threan.setUncaughtExceptionHandler(solution);

        threan.start();
    }
}
