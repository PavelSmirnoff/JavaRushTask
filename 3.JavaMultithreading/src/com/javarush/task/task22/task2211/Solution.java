package com.javarush.task.task22.task2211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");

        try (InputStream reader = new FileInputStream(args[0]);
             OutputStream writer = new FileOutputStream(args[1])) {

            byte[] buffer = new byte[1000];
            while (reader.available()>0) {
                reader.read(buffer);
                String s = new String(buffer,windows1251);
                writer.write(s.getBytes(utf8));
            }
        }
    }
}
