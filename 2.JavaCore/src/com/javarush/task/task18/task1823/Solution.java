package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream file = new FileInputStream(fileName)){
                byte[] byteCount = new byte[256];
                while(file.available()>0){
                    byteCount[file.read()]++;
                }
                int maxCount = 0;
                int numByte = 0;
                for(int i = 0; i <byteCount.length; i++){
                    if(maxCount<byteCount[i]){
                        maxCount = byteCount[i];
                        numByte = i;
                    }
                }
                resultMap.put(fileName, numByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
