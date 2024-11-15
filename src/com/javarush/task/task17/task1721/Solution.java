package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readerFileOne = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader readerFileTwo = new BufferedReader(new FileReader(reader.readLine()))) {
            String line;
            while ((line = readerFileOne.readLine()) != null) {
                allLines.add(line);
            }
            while ((line = readerFileTwo.readLine()) != null) {
                forRemoveLines.add(line);
            }
            Solution solution = new Solution();
            solution.joinData();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
