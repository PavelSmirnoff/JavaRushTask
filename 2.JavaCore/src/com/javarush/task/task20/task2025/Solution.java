package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        for(long i=1; i<=N; i++){
            int leight = String.valueOf(i).length();
            long[] arrayN = new long[leight];
            long number = i;
            for (int ii = 0; ii < leight; ii++)
            {
                arrayN[ii] = number % 10;
                //System.out.println(arrayN[ii]);
                number = number / 10;
            }
            long x = Arrays.stream(arrayN).reduce(0, (a , z) -> (long) (a + Math.pow(z, leight)));
            //System.out.println(i + " " + x);
            if(i == x) list.add(i);
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
