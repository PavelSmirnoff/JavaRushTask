package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файловые операции
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Path p1 = Path.of(new Scanner(System.in).nextLine());
        Path p2 = Path.of(new Scanner(System.in).nextLine());

        if (!Files.exists(p1)){
            Files.createFile(p1);
        } else if (!Files.exists(p2)) {
            Files.move(p1, p2);
        } else {
            Files.delete(p1);
        }
    }
}

