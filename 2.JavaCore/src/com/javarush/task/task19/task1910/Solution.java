package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file1 = reader.readLine();
        file2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while (reader1.ready()) {
            String str = reader1.readLine().replaceAll("\\p{P}","");
            writer.write(str);
        }
        reader1.close();
        writer.close();
    }
}
