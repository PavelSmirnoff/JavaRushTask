package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Path p1 = Path.of(new Scanner(System.in).nextLine());
        Path p2 = Path.of(new Scanner(System.in).nextLine());
        try {
            System.out.println(p1.relativize(p2));
        } catch (Exception e) {
            try {
                System.out.println(p2.relativize(p1));
            } catch (Exception ignore) {

            }
        }

    }
}

