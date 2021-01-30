package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Random;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

           // StringBuffer buffer = new StringBuffer();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (FileInputStream fileInputStream1 = new FileInputStream(file1);
                 FileInputStream fileInputStream2 = new FileInputStream(file2);) {
                while(fileInputStream2.available()>0){
                    byteArrayOutputStream.write(fileInputStream2.read());
                }
                while(fileInputStream1.available()>0){
                    byteArrayOutputStream.write(fileInputStream1.read());
                }
            } catch (IOException irnored) {
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(file1);) {
                byteArrayOutputStream.writeTo(fileOutputStream);
            } catch (IOException irnored) {
            }

        } catch (IOException ignored) {
        }
    }
}
