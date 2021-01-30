package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader readFromFile = new BufferedReader(new FileReader(reader.readLine()));

        while(readFromFile.ready()){
            String str = readFromFile.readLine();
            String[] strS = str.split(" ");
            if (strS[0].equals(args[0])){
                System.out.println(str);
            }
        }

        reader.close();
        readFromFile.close();
    }
}
