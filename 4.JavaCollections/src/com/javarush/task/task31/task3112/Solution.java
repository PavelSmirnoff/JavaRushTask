package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        Path downloadPath = downloadDirectory.resolve(urlString.split("/")[urlString.split("/").length - 1]);

        URL url = new URL(urlString);

        Path tempFile = Files.createTempFile(null, null);
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

        Files.move(tempFile, downloadPath);

        return downloadPath;
    }
}
