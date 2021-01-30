package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        FileReader fileReader = new FileReader(args[0]);
            while (fileReader.ready()) {
                char readChar = (char) fileReader.read();
                if (((readChar >= 'a') && (readChar <= 'z')) || ((readChar >= 'A') && (readChar <= 'Z'))) {
                    count++;
                }
            }
        System.out.println(count);
        fileReader.close();
    }
}
