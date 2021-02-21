package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Алгоритмы-числа
*/

public class Solution {
    public static long[][] pows;

    public static long[] getNumbers(long N) {
        if (N <= 0) return new long[0];

        int length = String.valueOf(N).length();
        if (length > 20) return new long[0];

        genPows(length);
        int[] num = new int[length + 1];
        Set<Long> set = new TreeSet<>();

        for (long n = 1L; n <= N; n++) {
            set.add(sorting(n));
        }

        System.out.println(set);

//        for(long n=1L; n <=N ; n++){
//            int length = String.valueOf(n).length();
//            long sum = 0;
//            long num = n;
//            while (num > 0){
//                sum += Math.pow(num%10,length);
//                num /= 10;
//                if (sum > n) break;
//            }
//            if (sum == n) numbers.add(n);
//        }


        return null;
    }

    public static long sorting(long n) {

        return n;
    }

    public static void genPows(int length) {
        pows = new long[10][length + 1];
        for (int n = 0; n < 10; n++) {
            for (int l = 0; l < length; l++) {
                pows[n][l] = (long) Math.pow(n, l);
            }
        }
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
