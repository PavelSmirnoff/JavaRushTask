package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while(reader.ready()){
            String str = reader.readLine();
            String[] date = str.split("\\D+");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(date[3]), Integer.parseInt(date[2])-1 , Integer.parseInt(date[1]));
            PEOPLE.add(new Person(str.replaceAll("\\d","").trim(), calendar.getTime()));
        }

        reader.close();
    }
}
