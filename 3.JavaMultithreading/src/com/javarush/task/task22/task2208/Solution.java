package com.javarush.task.task22.task2208;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        String prefix = "";
        for (Map.Entry<String,String> p : params.entrySet() ) {
            if(p.getValue() != null) {
                builder.append(prefix)
                        .append(p.getKey())
                        .append(" = '")
                        .append(p.getValue())
                        .append("'");
                prefix =  " and ";
            }
        }
        return builder.toString();
    }
}
