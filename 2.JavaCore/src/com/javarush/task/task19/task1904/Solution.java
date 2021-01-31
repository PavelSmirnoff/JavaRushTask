package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
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
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] str = fileScanner.nextLine().split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(str[5]), Integer.parseInt(str[4]) - 1, Integer.parseInt(str[3]));
            Date date = calendar.getTime();

            return new Person(str[1], str[2], str[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
