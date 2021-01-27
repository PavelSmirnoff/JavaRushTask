package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileRead = new FileInputStream(reader.readLine());
             FileOutputStream fileWrite = new FileOutputStream(reader.readLine());) {

            int count = fileRead.available();
            byte[] buff = new byte[fileRead.available()];

            int countRead = fileRead.read(buff);

            while (count > 0) {
                fileWrite.write(buff[--count]);
            }


        } catch (IOException ignored) {
        }
    }
}
