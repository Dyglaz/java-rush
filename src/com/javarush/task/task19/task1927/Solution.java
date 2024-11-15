package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();
        System.setOut(consoleStream);

        //Преобразовываем записанные в наш ByteArray данные в строку
        String[] lines = outputStream.toString().split("\n");
        for (int i = 0; i < lines.length; i++) {
            if(i != 0 && i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(lines[i]);
            } else System.out.println(lines[i]);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }


}
