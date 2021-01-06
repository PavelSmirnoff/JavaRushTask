package com.javarush.task.pro.task13.task1312;

import java.util.ArrayList;
import java.util.HashMap;

/* 
ArrayList vs HashMap
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getProgrammingLanguages());
    }

    public static HashMap<Integer, String> getProgrammingLanguages() {
        //напишите тут ваш код
        HashMap<Integer, String> programmingLanguages = new HashMap<>() {{
            put(0, "Java");
            put(1, "Kotlin");
            put(2, "Go");
            put(3, "Javascript");
            put(4, "Typescript");
            put(5, "Python");
            put(6, "PHP");
            put(7, "C++");
        }};

        return programmingLanguages;
    }

}
