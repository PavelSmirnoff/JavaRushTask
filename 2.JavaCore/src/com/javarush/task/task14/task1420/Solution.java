package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int x1 = Integer.parseInt(bufferedReader.readLine());
        int x2 = Integer.parseInt(bufferedReader.readLine());
        int nod = 0;
        int xMin = Math.min(x1, x2);
        int xMax = Math.max(x1, x2);

        if (xMin < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = xMin; i >= 1; i--) {
            if ((xMin % i == 0) && (xMax % i == 0)) {
                nod = i;
                break;
            }
        }
        System.out.println(nod);

    }
}
