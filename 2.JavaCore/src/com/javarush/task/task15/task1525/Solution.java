package com.javarush.task.task15.task1525;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        System.out.println(Statics.FILE_NAME);
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(Statics.FILE_NAME)));)
        {
            String line;
            while((line = reader.readLine())!=null){
                lines.add(line);
            }
        }catch (Exception ignored){

        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
