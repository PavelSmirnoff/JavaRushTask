package com.javarush.task.task19.task1917;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    FileConsoleWriter(String fileName ) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName,append);
    }
    FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    FileConsoleWriter(FileDescriptor fd){
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }
    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(new String(str).substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        System.out.println(new String(cbuf));
    }
    public void close() throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
