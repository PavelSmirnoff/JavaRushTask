package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        Solution.reset();
    }

    public static CanFly result;

    public static void reset(){
        //add your code here - добавьте код тут
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String str = bufferedReader.readLine();
            if(str.equals("helicopter")){
                result = new Helicopter();
            }else if(str.equals("plane")){
                result = new Plane(Integer.parseInt(bufferedReader.readLine()));
            }

        }catch (Exception ignored){

        }
    }
}
