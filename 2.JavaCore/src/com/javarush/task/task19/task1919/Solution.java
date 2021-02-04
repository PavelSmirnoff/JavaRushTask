package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String,Double> salaryList = new TreeMap<>();

        while (fileReader.ready()){
            String[] data = fileReader.readLine().split(" ");
            salaryList.merge(data[0],Double.parseDouble(data[1]),(a,b) -> a+=b);
        }

        salaryList.forEach((k,v) -> System.out.println(k + " " + v));

        fileReader.close();
    }
}
