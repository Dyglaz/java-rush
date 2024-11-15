package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if(args[0].equals("-c")) {
            Person person = (args[2].equals("м"))
                    ? Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]))
                    : Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (args[0].equals("-r")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж")
                    + " " + new SimpleDateFormat("dd-MMM-yyyy").format(person.getBirthDate()));
        } else if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setSex((args[3].equals("м")) ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
        } else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
}
