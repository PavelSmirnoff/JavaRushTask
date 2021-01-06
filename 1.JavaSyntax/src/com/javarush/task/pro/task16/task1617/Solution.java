package com.javarush.task.pro.task16.task1617;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution {

    static LocalDateTime localTime = LocalDateTime.of(2020, 3, 19, 9, 17);
    static ZoneId zoneId = ZoneId.of("Zulu");
    static ZonedDateTime globalTime;

    public static void main(String[] args) {
        //напишите тут ваш код
        globalTime = ZonedDateTime.of(localTime,zoneId);
        System.out.println(globalTime);
    }
}
