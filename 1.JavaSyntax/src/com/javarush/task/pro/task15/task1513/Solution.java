package com.javarush.task.pro.task15.task1513;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Зри в корень
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String str = new Scanner(System.in).nextLine();
        System.out.println(Path.of(str).getRoot());
    }
}

