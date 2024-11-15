package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            while(reader.ready()){
                String[] lines;
                StringBuffer fullName  = new StringBuffer();
                lines = reader.readLine().split(" ");
                Date date = formatter.parse(lines[lines.length - 3]
                        + " " + lines[lines.length - 2]
                        + " " + lines[lines.length - 1]);
                for (int i = 0; i < lines.length - 3; i++) {
                    fullName.append(lines[i]).append(" ");
                }
                PEOPLE.add(new Person(fullName.toString().trim(), date));
            }
        }
    }
}
