package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();


        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String str;//= "Это стоит 1 бакс, а вот это - 12 . Переменная имеет имя file1. 110 - это число.";
        StringBuffer sbLine = new StringBuffer();
        while ((str = reader1.readLine()) != null) {
            String[] strbuff = str.split(" ");
            for (int i = 0; i < strbuff.length; i++) {
                try {
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        if (Integer.parseInt(strbuff[i]) == entry.getKey()) {
                            strbuff[i] = entry.getValue();
                            //str = str.replaceAll("" + entry.getKey() + "", " " + entry.getValue() + " ");
                        }
                    }
                    sbLine.append(strbuff[i]).append(" ");
                } catch (Exception ignored) {
                    sbLine.append(strbuff[i]).append(" ");
                }
            }
        }
        System.out.println(sbLine.toString().trim());

        reader.close();
        reader1.close();

    }
}
