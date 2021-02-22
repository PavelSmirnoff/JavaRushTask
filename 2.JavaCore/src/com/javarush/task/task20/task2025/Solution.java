package com.javarush.task.task20.task2025;

import javafx.scene.effect.Blend;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {

    private static int length;
    public static long[][] pows;

    public static long[] getNumbers(long N) {
        if(N<=1) return new long[0];

        length = String.valueOf(N).length();
        setPows(length);

        List<Long> numbers = new ArrayList<>();
        Set<Long> set = new HashSet<>();


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


        return null;//numbers.stream().mapToLong(Long::longValue).toArray();
    }

    private static void setPows(int N){
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    public static long sort(long n) {
        // For testing purposes:
        // System.out.println("sort(" + n + ")");

        if (n < 10) return n;   // Termination condition

        int numOfDigits = (int)(Math.log10(n)+1);
        long largestDigit = n % 10;
        long restOfDigits = n / 10;

        for(int i=0; i<numOfDigits; i++) {
            long current = (long) (n / Math.pow(10, i)) % 10;
            if (current > largestDigit) {
                largestDigit = current;
                restOfDigits = (long) Math.pow(10, i) * (n / (long) Math.pow(10, i + 1))
                        + (n % (long) Math.pow(10, i));
            }
        }

        // Merge the largest number on the right
        return 10 * sort(restOfDigits) + largestDigit;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
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
