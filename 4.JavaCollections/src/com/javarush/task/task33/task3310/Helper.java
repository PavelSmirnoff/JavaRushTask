package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Helper {
    static public String generateRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(36);
    }

    static public void printMessage(String message){
        System.out.println(message);
    }
}
