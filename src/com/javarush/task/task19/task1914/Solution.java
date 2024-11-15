package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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

        //Преобразовываем записанные в наш ByteArray данные в строку
        String[] strings = outputStream.toString().split(" ");
        String result = "";
        if(strings[1].equals("+")){
            result = String.valueOf(Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]));
        } else if(strings[1].equals("-")){
            result = String.valueOf(Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]));
        } else if(strings[1].equals("*")){
            result = String.valueOf(Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]));
        }

        //Возвращаем все как было
        System.setOut(consoleStream);

        //разворачиваем строку

        //выводим ее в консоль
        System.out.println(strings[0] + " " + strings[1] + " " + strings[2] + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

