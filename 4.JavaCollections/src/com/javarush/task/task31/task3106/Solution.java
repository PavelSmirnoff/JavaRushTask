package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileOut = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        List<String> listFiles = new ArrayList<>();
        List<FileInputStream> listIS = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            listFiles.add(args[i]);
        }
        Collections.sort(listFiles);
        for (String nameFile : listFiles) {
            listIS.add(new FileInputStream(nameFile));
        }
            try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listIS)))) {
                while (is.getNextEntry() != null) {
                    while(is.available() > 0) {
                        try (OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(fileOut))) {
                            final int bufferSize = 1024;
                            byte[] buffer = new byte[bufferSize];
                            for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                                fileOutputStream.write(buffer, 0, readBytes);
                            }
                            fileOutputStream.flush();
                        }
                    }
                }
            }
    }
}
