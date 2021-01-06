package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        URL url = new URL(new Scanner(System.in).nextLine());
        InputStream input = url.openStream();

        Files.write(Files.createTempFile(null,null),input.readAllBytes());
    }
}