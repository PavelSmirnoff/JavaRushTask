package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        if (N <= 1) return new long[0];

        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= N; i++) {
            int lenght = String.valueOf(i).length()+1;
            //System.out.println(leight);
            //if (leight > 20) break;
            //long[] arrayN = new long[leight];
            long number = i;
            long pows = 0;
            long sum = 0;
            for (int ii = 0; ii < lenght; ii++) {
                pows = (long) Math.pow(number % 10, lenght);

                if ((sum += pows) > i) break;
                number = number / 10;
            }
            //System.out.println(i + " " + x);
            if (i == sum) list.add(i);
        }
        return list.stream().mapToLong(l -> l).toArray();
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
