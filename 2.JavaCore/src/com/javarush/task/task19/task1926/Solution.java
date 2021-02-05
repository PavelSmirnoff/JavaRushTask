package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(file.readLine()));

        while (reader.ready()){
            System.out.println(new StringBuilder().append(reader.readLine()).reverse());
        }

        reader.close();
        file.close();
    }
}
