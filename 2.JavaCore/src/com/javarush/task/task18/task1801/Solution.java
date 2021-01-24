package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(fileName.readLine());

        int maxByte = 0;
        while (inputStream.available() > 0){
            maxByte = Math.max(maxByte,inputStream.read());
        }
        System.out.println(maxByte);
        
        inputStream.close();
    }
}
