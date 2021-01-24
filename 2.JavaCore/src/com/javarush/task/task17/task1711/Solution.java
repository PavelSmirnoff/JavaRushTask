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
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //String[] args = {"-u", "0", "sdssds", "ж", "12/12/1212"};
        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    synchronized (allPeople) {
                        allPeople.add(getPerson(args[i], args[i + 1], args[i + 2]));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                for (int i = 1; i < args.length; i += 4) {
                    synchronized (allPeople) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i+1]);
                        person.setSex(getSex(args[i+2]));
                        person.setBirthDate(simpleDateFormat.parse(args[i+3]));
                    }
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + getSex(person.getSex()) + " " + simpleDateFormat2.format(person.getBirthDate()));
                    }
                }
                break;
        }
    }

    private static Sex getSex(String sex) {
        if (sex.equals("м")) return Sex.MALE;
        else return Sex.FEMALE;
    }

    private static String getSex(Sex sex) {
        if (sex.equals(Sex.MALE)) return "м";
        else return "ж";
    }

    private static Person getPerson(String name, String sex, String date) throws ParseException {
        switch (getSex(sex)) {
            case MALE:
                return Person.createMale(name, simpleDateFormat.parse(date));
            case FEMALE:
                return Person.createFemale(name, simpleDateFormat.parse(date));
        }
        return null;
    }

}
