package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int x = 0;
        while(fileReader.ready()){
            int bR= fileReader.read();
            if((++x%2) == 0) fileWriter.write(bR);
        }

        fileReader.close();
        fileWriter.close();

    }
}
