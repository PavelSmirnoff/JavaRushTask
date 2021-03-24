package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> strings = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            strings.add(tokenizer.nextToken());
        }
        return strings.toArray(new String[0]);
    }
}
