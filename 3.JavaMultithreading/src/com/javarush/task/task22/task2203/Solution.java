package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null) throw new TooShortStringException();
        String[] strings = string.split("\t");

        if(strings.length<=2) throw new TooShortStringException();
        System.out.println(strings.length);
        return strings[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString(null));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java\t."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
