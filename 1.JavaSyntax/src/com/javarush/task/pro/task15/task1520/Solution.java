package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Глубокое копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Path curPath = Path.of(new Scanner(System.in).nextLine());
        Path newPath = Path.of(new Scanner(System.in).nextLine());


        Files.walk(curPath).forEach(path -> {
            try {
                Files.copy(path, newPath.resolve(curPath.relativize(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

