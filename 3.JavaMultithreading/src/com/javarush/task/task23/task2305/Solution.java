package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] s = new Solution[2];
        s[0] = new Solution();
        s[0].innerClasses[0] = s[0].new InnerClass();
        s[0].innerClasses[1] = s[0].new InnerClass();
        s[1] = new Solution();
        s[1].innerClasses[0] = s[1].new InnerClass();
        s[1].innerClasses[1] = s[1].new InnerClass();
        return s;
    }

    public static void main(String[] args) {

    }
}
