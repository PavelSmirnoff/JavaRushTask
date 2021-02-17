package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName,true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName1 = "/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/test.txt";
        String fileName2 = "/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/test_out.txt";

        try (FileOutputStream fileOutput = new FileOutputStream(fileName2);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
             FileInputStream fiStream = new FileInputStream(fileName2);
             ObjectInputStream objectStream = new ObjectInputStream(fiStream)
        ) {
            Solution solution = new Solution(fileName1);
            solution.writeObject("some text");

            outputStream.writeObject(solution);
            outputStream.flush();

            //load object from file
            Solution loadedObject = (Solution) objectStream.readObject();

            loadedObject.writeObject("some text - 2");
        } catch (Exception skipped) {
        }
    }
}
