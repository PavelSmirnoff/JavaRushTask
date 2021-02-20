package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int colRect = 0;
        int rowRect = 0;
        int count = 0;

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] == 1) {
                    count++;
                    colRect = col;
                    rowRect = row;

                    while (a[rowRect][colRect] == 1) {
                        if(colRect == a[rowRect].length-1 || a[rowRect][colRect+1] == 0) break;
                        colRect++;
                    }
                    while (a[rowRect][colRect] == 1) {
                        if(rowRect == a.length-1 || a[rowRect+1][colRect] == 0) break;
                        rowRect++;
                    }
                }
                //System.out.println("Start:" + row + " " + col);
                //System.out.println("End:" + rowRect + " " + colRect);
                StringBuilder str = new StringBuilder();
                for (int rowE = row; rowE <= rowRect; rowE++) {
                    for (int colE = col; colE <= colRect; colE++) {
                        a[rowE][colE] = 0;
                        str.append(a[rowE][colE]);
                    }
                    str.append("\n");
                }
                //System.out.println(str.toString());
                //System.out.println("rect:" + count);
            }
        }

        return count;
    }
}
