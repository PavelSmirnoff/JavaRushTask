package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file);
        StringBuffer str = new StringBuffer();
        while (fileReader.ready()){
            str.append((char)fileReader.read());
        }
        System.out.println(Arrays.stream(str.toString()
                .replaceAll("\\p{P}", " ").replaceAll("\\s", " ")
                .split(" ")).filter(x -> x.equals("world")).count());
        fileReader.close();
    }
}
