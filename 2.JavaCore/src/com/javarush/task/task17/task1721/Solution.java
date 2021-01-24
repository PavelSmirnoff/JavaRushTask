package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args){
//       String exampleString = "/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/allLines" + "\n"
//                + "/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/forRemoveLines";
//        System.setIn(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

            String strLine;
            BufferedReader allLinesFile = new BufferedReader(new FileReader(reader.readLine()));
            while ((strLine = allLinesFile.readLine()) != null)   {
                allLines.add(strLine);
            }
            BufferedReader forRemoveLinesFile = new BufferedReader(new FileReader(reader.readLine()));
            while ((strLine = forRemoveLinesFile.readLine()) != null)   {
                forRemoveLines.add(strLine);
            }
            System.out.println(allLines);
            System.out.println(forRemoveLines);

        } catch (IOException ignored) {
        }

        try {
            new Solution().joinData();


        }catch (CorruptedDataException e){

        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            for (String s: forRemoveLines) {
                allLines.removeIf(x -> x.equals(s));
            }
        }else{
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }

    }
}
