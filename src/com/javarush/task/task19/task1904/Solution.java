package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String[] tokens = fileScanner.nextLine().split(" ");
            try {
                return new Person(tokens[1], tokens[2], tokens[0], new SimpleDateFormat("dd MM yyyy").parse(tokens[3] + " " + tokens[4] + " " + tokens[5]));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
