package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> worker = new TreeMap<>();

        while (reader.ready()){
            String[] str = reader.readLine().split(" ");
            worker.merge(str[0],Double.parseDouble(str[1]),(a,v) -> a+=v);
        }

        double max = worker.values().stream().mapToDouble(x-> Double.valueOf(x)).max().getAsDouble();

        worker.entrySet().stream().filter((k -> k.getValue() >= max)).forEach(x -> System.out.println(x.getKey()));

        reader.close();
    }
}
