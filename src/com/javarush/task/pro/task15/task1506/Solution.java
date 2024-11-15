package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            List<String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
            for(String s : lines){
                for(Character c : s.toCharArray()){
                    if(!c.equals('.') && !c.equals(',') && !c.equals(' ')){
                        System.out.print(c);
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

