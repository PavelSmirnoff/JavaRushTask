package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFile = new File(args[1]);
        File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(dest)) {
            FileUtils.deleteFile(dest);
        }
        FileUtils.renameFile(resultFile, dest);

        File rootDir = new File(args[0]);
        TreeMap<String, File> files = new TreeMap<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                if (currentFile.length() <= 50) {
                    files.put(currentFile.getName(), currentFile);
                }
            }
        }

        //FileOutputStream outputStream = new FileOutputStream(dest);
        FileWriter fileWriter = new FileWriter(dest);
        for (File file : files.values()) {
//            try (FileInputStream fileInputStream = new FileInputStream(file)) {
//                byte[] bytes = new byte[fileInputStream.available()];
//                outputStream.write(fileInputStream.read(bytes));
//                outputStream.write("\n".getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                FileReader fileReader = new FileReader(file);
                String tempText = "";
                while (fileReader.ready()) {
                    int data = fileReader.read();
                    tempText += (char) data;
                }
                fileWriter.write(tempText + "\n");
                fileReader.close();
            } catch (FileNotFoundException e) {}
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
