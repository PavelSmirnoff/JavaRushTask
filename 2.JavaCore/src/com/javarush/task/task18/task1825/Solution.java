package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName, outputFile = null;
        Set<String> filePath = new TreeSet<>();
        while (!(fileName = reader.readLine()).equals("end")) {
            filePath.add(fileName);
            int indexOfSuffix = fileName.lastIndexOf(".part");
            outputFile = fileName.substring(0, indexOfSuffix);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        for (String file : filePath) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                int bytesRead = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileInputStream.close();
        }

        fileOutputStream.close();
        reader.close();
    }
}
