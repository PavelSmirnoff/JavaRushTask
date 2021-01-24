package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        int byteRead;
        int maxCount = 0;
        while (fileInputStream.available() > 0) {
            byteRead = fileInputStream.read();
            if (counts.containsKey(byteRead)) {
                counts.put(byteRead, counts.get(byteRead) + 1);
            } else {
                counts.put(byteRead, 1);
            }
        }
        for (Integer value: counts.values()){
            maxCount = Math.max(maxCount,value);
        }


        int finalMaxCount = maxCount;
        counts.forEach((k, v) -> { if(v.equals(finalMaxCount)) System.out.print(k + " "); });

        reader.close();
        fileInputStream.close();
    }
}
