package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path directory = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            directory = Paths.get(reader.readLine());
        }catch (IOException ignored){}

        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        AtomicLong sizeFile = new AtomicLong();
        if(Files.isDirectory(directory)){
            Path finalDirectory = directory;
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount.incrementAndGet();
                    sizeFile.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(finalDirectory)) dirCount.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }
            });

            }else {
            System.out.println(directory.toString() + " - не папка.");
        }

        System.out.println("Всего папок - " + dirCount.get());
        System.out.println("Всего файлов - " + fileCount.get());
        System.out.println("Общий размер - " + sizeFile.get());

    }
}
