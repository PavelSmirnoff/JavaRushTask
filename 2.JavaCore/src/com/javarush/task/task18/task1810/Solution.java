package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 FileInputStream fileInputStream = new FileInputStream(reader.readLine());) {
            if ( fileInputStream.available() < 1000) throw new DownloadException();

            } catch (IOException ignored) {
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}