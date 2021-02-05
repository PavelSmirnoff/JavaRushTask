package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        List<String> list = new ArrayList<>();
        String str;//= "длинное короткое аббревиатура";

        while ((str = reader.readLine()) != null) {
            for (String s : str.split(" ")) {
                if (s.length() > 6) list.add(s);
            }
        }
        str = list.stream().reduce("", (a, x) -> a += x + ",");

        System.out.println(str.substring(0, str.length() - 1));
        writer.write(str.substring(0, str.length() - 1));

        reader.close();
        writer.close();
    }
}
