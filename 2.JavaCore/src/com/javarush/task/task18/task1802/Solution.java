package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int minByte = 255;
        while (fileInputStream.available() > 0) {
            minByte = Math.min(minByte,fileInputStream.read());
        }
        System.out.println(minByte);

        reader.close();
        fileInputStream.close();
    }
}
