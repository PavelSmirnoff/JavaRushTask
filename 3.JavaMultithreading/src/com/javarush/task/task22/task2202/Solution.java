package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String[] strings = string.split(" ");
        
        if( strings.length <= 4) throw new TooShortStringException();
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            str.append(strings[i]).append(" ");
        }
        return str.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
