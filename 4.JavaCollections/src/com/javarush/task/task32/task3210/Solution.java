package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int seek = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        raf.seek(seek);
        byte[] buffer = new byte[text.length()];
        raf.read(buffer,0, text.length());
        String readText = new String(buffer);
        raf.seek(raf.length());
        if (text.equals(readText)) raf.write("true".getBytes()); else raf.write("false".getBytes());
    }
}
