package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file));

        while (reader1.ready()) {
            String str = reader1.readLine();
            String[] strArray = str.split(" ");
            int count = 0;
            for (int i = 0; i < strArray.length; i++) {
                for (String s : words) {
                    if (strArray[i].equals(s)) count++;
                }
            }
            if (count == 2) System.out.println(str);
        }

        reader1.close();
    }
}
