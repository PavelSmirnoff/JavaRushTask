package com.javarush.task.task18.task1820;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {

//        double a = 3.49;// => 3
//        double b = 3.50;// => 4
//        double c = 3.51;// => 4
//        double d = -3.49;// => -3
//        double e = -3.50;// => -3
//        double f = -3.51;// => -4
//
//        System.out.printf("%d ",Math.round(a));
//        System.out.printf("%d ",Math.round(b));
//        System.out.printf("%d ",Math.round(c));
//        System.out.printf("%d ",Math.round(d));
//        System.out.printf("%d ",Math.round(e));
//        System.out.printf("%d ",Math.round(f));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            String fileRead = reader.readLine();
            String fileWrite = reader.readLine();

            try(Scanner scanner = new Scanner(new FileInputStream(fileRead));
                FileOutputStream write = new FileOutputStream(fileWrite)) {
                while (scanner.hasNextDouble()) {
                    write.write(String.format("%d ", Math.round(scanner.nextDouble())).getBytes());
                }
            }
        } catch (IOException ignored) {

        }
    }
}
