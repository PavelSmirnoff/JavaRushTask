package com.javarush.task.task25.task2512;

import java.util.*;
import java.util.stream.Collectors;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> list = new LinkedList<>();
        while (e != null) {
            list.add(0, e.toString());
            e = e.getCause();
        }
        list.forEach(System.out::println);

    }

    public static void main(String[] args) {
    }
}
