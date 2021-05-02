package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    static final char[][] symbol = {{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'},
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());

    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            byteArrayOutputStream.write(symbol[(i<3)?i:random.nextInt(3)]
                    [random.nextInt(symbol.length)]);
        }
        return byteArrayOutputStream;
    }
}
