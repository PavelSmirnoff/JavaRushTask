package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream file = new FileInputStream(reader.readLine());) {
            int count = 0;
            int symbol;
            while (file.available() > 0) {
                if (file.read() == ',') count ++;
            }
            System.out.println(count);
        } catch (IOException ignored) {

        }
    }
}
