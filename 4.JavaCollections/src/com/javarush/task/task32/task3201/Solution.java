package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int seek = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        if(raf.length() < seek) {
            raf.seek(raf.length());
        }else{
            raf.seek(seek);
        }
        raf.write(text.getBytes());
        raf.close();
    }
}
