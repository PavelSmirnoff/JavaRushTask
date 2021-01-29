package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {

        switch (args[0]) {
            case "-e":
                try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(args[1]));
                     BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(args[2]))) {
                    int i;
                    while ((i = fileReader.read()) != -1) {
                        fileWriter.write(i + 16);
                    }
                } catch (IOException ignored) {
                }
                break;
            case "-d":
                try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(args[1]));
                     BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(args[2]))) {
                    int i;
                    while ((i = fileReader.read()) != -1) {
                        fileWriter.write(i - 16);
                    }
                } catch (IOException ignored) {
                }
                break;
        }
    }

}
