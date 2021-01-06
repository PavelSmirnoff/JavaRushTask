package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

public class Solution {

    static Date birthDate = new Date(1982, Calendar.SEPTEMBER, 23);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        String day = "";
        switch (date.getDay()){
            case 1: day = "Понедельник"; break;
            case 2: day = "Вторник"; break;
            case 3: day = "Среда"; break;
            case 4: day = "Четверг"; break;
            case 5: day = "Пятница"; break;
            case 6: day = "Суббота"; break;
            case 0: day = "Воскресенье"; break;
        }
        return day;
    }
}
