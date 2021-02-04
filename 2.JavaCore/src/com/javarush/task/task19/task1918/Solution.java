package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // String fileName = "/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/1918.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder readFileContent = new StringBuilder();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            readFileContent.append(fileReader.readLine());
        }
        fileReader.close();

        //String testContent = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span>";
        //String test = "<span>1<span>2</span><span>3</span></span>";

//        String tag = args[0];//"div"; //
//        String fileContent = readFileContent.toString().replaceAll("\n\r", "");
//        String openTag = "<" + tag;
//        String closeTag = "</" + tag + ">";
//        String regExp = openTag + "|" + closeTag;
//        Pattern p = Pattern.compile(regExp);
//        Matcher m = p.matcher(fileContent);
//
//        Deque<Integer> startList = new LinkedList<>();
//        Deque<Integer> endList = new LinkedList<>();
//        List<String> listTag = new ArrayList<>();
//        String lastTag = "";
//        while (m.find()) {
//            if (m.group().equals(closeTag)) {
//                if (lastTag.equals(closeTag) && startList.size() == endList.size()) {
//                    endList.addFirst(m.end());
//                } else {
//                    endList.add(m.end());
//                }
////                //System.out.println("Конец" + (m.end()));
//            } else if (m.group().length() == openTag.length()) {
//                startList.add(m.start());
////                //System.out.println("Старт" + m.start());
//            }
//            lastTag = m.group();
//
//        }
//
////        System.out.println(startList.size());
////        System.out.println(endList.size());
//        while (startList.size() > 0) {
////            int x = startList.pop();
////            int y = endList.pop();
////            System.out.println(x + " - " + y);
////            System.out.println(fileContent.substring(x,y));
//            listTag.add(fileContent.substring(startList.pop(), endList.pop()));
//        }
//        listTag.forEach(System.out::println);

        String fileContent = readFileContent.toString().replaceAll("\r\n", "");

        String openTag = "<" + args[0];
        String closingTag = "</" + args[0];
        int tagLength = args[0].length();
        int startTagIndex = 0;
        int endTagIndex = 0;

        ArrayList<String> tags = new ArrayList<>();

        while ((startTagIndex != -1) && (startTagIndex < fileContent.length())) {
            startTagIndex = fileContent.indexOf(openTag, startTagIndex);
            endTagIndex = fileContent.indexOf(closingTag, startTagIndex + tagLength);

            int indexInTag = startTagIndex + tagLength;
            if (endTagIndex != -1) {
                while (fileContent.substring(indexInTag, endTagIndex).contains(openTag)) {
                    indexInTag = endTagIndex + tagLength;
                    endTagIndex = fileContent.indexOf(closingTag, indexInTag);
                }
            }
            if (startTagIndex != -1 && endTagIndex != -1) {
                tags.add(fileContent.substring(startTagIndex, endTagIndex + tagLength + 3));
                startTagIndex += tagLength;
            }
        }

        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}
