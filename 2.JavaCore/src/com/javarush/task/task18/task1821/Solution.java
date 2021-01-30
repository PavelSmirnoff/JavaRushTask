package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       // FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileReader reader = new FileReader(args[0]);
        Map<Character, Integer> mapChar = new TreeMap<>();

        while (reader.ready()){
            mapChar.merge((char)reader.read(), 1, Integer::sum);
        }
        mapChar.forEach((k,v) -> System.out.println(k + " " + v));

        reader.close();
    }
}
