package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        try {
            // Считываем имя файла с консоли
            System.out.print("Введите имя файла: ");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();

            // Читаем содержимое файла
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            // Разделяем строку на слова
            String[] words = line.split(" ");
            StringBuilder result = getLine(words);

            // Выводим результат
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения строки с переставленными словами
    private static StringBuilder getLine(String... words) {
        if(words.length == 0) return new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[words.length];
        List<String> result = new ArrayList<>();
        findSequence(words, used, sb, result, "");

        // Возвращаем первую найденную последовательность
        return result.isEmpty() ? new StringBuilder() : new StringBuilder(result.get(0));
    }

    // Рекурсивный метод для поиска последовательности слов
    private static void findSequence(String[] words, boolean[] used, StringBuilder sb, List<String> result, String current) {
        if (sb.length() == 0 && current.isEmpty()) {
            // Начинаем с каждого слова
            for (int i = 0; i < words.length; i++) {
                used[i] = true;
                sb.append(words[i]).append(" ");
                findSequence(words, used, sb, result, words[i]);
                sb.setLength(sb.length() - words[i].length() - 1); // Удаляем последнее слово
                used[i] = false;
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                if (!used[i] && current.charAt(current.length() - 1) == words[i].toLowerCase().charAt(0)) {
                    used[i] = true;
                    sb.append(words[i]).append(" ");
                    findSequence(words, used, sb, result, words[i]);
                    sb.setLength(sb.length() - words[i].length() - 1); // Удаляем последнее слово
                    used[i] = false;
                }
            }
        }

        // Если использованы все слова, добавляем результат
        if (sb.length() > 0 && sb.toString().trim().split(" ").length == words.length) {
            result.add(sb.toString().trim());
        }
    }
}
