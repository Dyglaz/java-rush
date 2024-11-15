package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) {
                        allPeople.add((args[i + 1].equals("м"))
                                ? Person.createMale(args[i], simpleDateFormat.parse(args[i + 2]))
                                : Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        person.setSex((args[i + 2].equals("м")) ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(simpleDateFormat.parse(args[i + 3]));
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person currentPerson = allPeople.get(Integer.parseInt(args[i]));
                        currentPerson.setName(null);
                        currentPerson.setSex(null);
                        currentPerson.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж")
                                + " " + simpleDateFormat2.format(person.getBirthDate()));
                    }
                }
        }
    }
}


