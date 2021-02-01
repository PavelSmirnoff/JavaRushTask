package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(printStream);

        String[] str = byteArrayOutputStream.toString().split(" ");
        int first = Integer.parseInt(str[0]);
        int second = Integer.parseInt(str[2]);
        int result = 0;
        switch (str[1]){
            case "+": result = first + second; break;
            case "*": result = first * second; break;
            case "-": result = first - second; break;
        }
        System.out.println(first + " " + str[1] + " " + second + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

