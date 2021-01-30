package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                fileName = reader.readLine();
                try (FileInputStream file = new FileInputStream(fileName)) {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } catch (IOException ignored) {
        }

    }
}
