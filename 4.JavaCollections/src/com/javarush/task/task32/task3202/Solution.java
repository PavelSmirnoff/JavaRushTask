package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if(is == null) return writer;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        //StringBuilder stringBuilder = new StringBuilder();
        if(reader.ready()){
            //stringBuilder.append(reader.readLine());
            writer.write(reader.readLine());
        }
        return writer;
    }
}
