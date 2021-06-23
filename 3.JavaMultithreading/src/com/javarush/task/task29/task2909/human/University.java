package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


//    public University(String name, int age) {
//        super(name, age, 0);
//    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        return students.stream().filter(x -> x.getAverageGrade() == value).findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double max = Double.MIN_VALUE;
        Student s = null;
        for (Student student : students) {
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                s = student;
            }
        }
        return s;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double min = Double.MAX_VALUE;
        Student s = null;
        for (Student student : students) {
            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                s = student;
            }
        }
        return s;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}