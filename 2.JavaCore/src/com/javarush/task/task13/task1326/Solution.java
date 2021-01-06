package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        List<Integer> data = new ArrayList<Integer>();

        int x;
        while (scanner.hasNext()) {
            x = scanner.nextInt();
            if (Math.abs(x) % 2 == 0) {
                data.add(x);
            }
        }
        data.sort(Comparator.naturalOrder());
        data.forEach(System.out::println);
        fileInputStream.close();
    }
}
