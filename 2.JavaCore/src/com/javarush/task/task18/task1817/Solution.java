package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(args[0]);) {
            int countChar = 0;
            int countSpace = 0;
            while (fileReader.ready()) {
                int ch = fileReader.read();
                if (ch == (int) ' ') countSpace++;
                countChar++;
            }
            double result = (double) countSpace / countChar * 100;
            System.out.printf("%.2f", result);

        }catch (IOException ignored){}
    }
}
