package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        List<String> oldFileLines = readFileLines(firstFile);
        List<String> newFileLines = readFileLines(secondFile);

        int oldFileLine = 0;
        int newFileLine = 0;

        while(oldFileLine < oldFileLines.size() && newFileLine < newFileLines.size()) {
            if(oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if((newFileLines.size() > newFileLine) && (oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine + 1)))) {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLines.size() > oldFileLine) && (oldFileLines.get(oldFileLine + 1).equals(newFileLines.get(newFileLine)))) {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while(oldFileLine < oldFileLines.size()) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
            oldFileLine++;
        }

        while(newFileLine < newFileLines.size()) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
            newFileLine++;
        }

    }

    public static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> oldFileLines = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null){
            oldFileLines.add(line);
        }
        reader.close();
        return oldFileLines;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
