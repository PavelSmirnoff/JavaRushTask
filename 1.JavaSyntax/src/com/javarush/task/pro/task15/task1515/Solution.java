package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Path p = Path.of(new Scanner(System.in).nextLine());
        System.out.println((p.isAbsolute()?p:p.toAbsolutePath()));
    }
}

