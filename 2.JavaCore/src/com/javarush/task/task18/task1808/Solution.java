package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileRead = new FileInputStream(reader.readLine());
        FileOutputStream fileWrite2 = new FileOutputStream(reader.readLine());
        FileOutputStream fileWrite3 = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[1000];

        while (fileRead.available() > 0) {
            int count = fileRead.read(buffer);
            int x = (count % 2 == 0) ? count / 2 : count / 2 + 1;
            fileWrite2.write(buffer, 0, x);
            fileWrite3.write(buffer, x, count - x);
        }

        reader.close();
        fileRead.close();
        fileWrite2.close();
        fileWrite3.close();
    }
}
