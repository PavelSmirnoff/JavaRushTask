package com.javarush.task.pro.task14.task1414;

public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        //напишите тут ваш код
        for (StackTraceElement info: stackTrace) {
            System.out.printf("Метод %s вызван из строки %s класса %s в файле %s.%n",info.getMethodName(),info.getLineNumber(),info.getClassName(),info.getFileName());
        }
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
