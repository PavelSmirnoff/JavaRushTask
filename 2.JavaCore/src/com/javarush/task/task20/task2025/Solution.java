package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> num = new ArrayList<>();
            int ii = i;
            while (ii >= 10) {
                num.add(ii % 10);
                ii = ii / 10;
            }
            num.add(ii % 10);

            long sum = 0L;
            for (Integer nn : num) {
                sum += Math.pow(nn, num.size());
                if (sum > i) break;
            }
            if (sum == i) list.add(sum);
        }
        return list.stream().mapToLong(Math::toIntExact).toArray();
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
