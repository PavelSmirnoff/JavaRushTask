package com.javarush.task.pro.task12.task1221;

import java.util.ArrayList;

/* 
Дженерики и студенты
*/

public class Faculty {

    public static void main(String[] args) {
        var students = new ArrayList<Student>();
        students.add(new Student("Акакий"));
        students.add(new Student("Любослав"));
        //students.add("Анатолий");
        //students.add(new Thread());
        //students.add(new Student[]{new Student("Афанасий"), new Student("Платон")});

        printStudentNames(students);
    }

    public static void printStudentNames(ArrayList<Student> students) {
       students.forEach(student -> {
           System.out.println((student).getName());
       });
    }
}
