package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        return new byte[]{
                (byte) ((ip[0]&0xFF)&(mask[0]&0xFF)),
                (byte) ((ip[1]&0xFF)&(mask[1]&0xFF)),
                (byte) ((ip[2]&0xFF)&(mask[2]&0xFF)),
                (byte) ((ip[3]&0xFF)&(mask[3]&0xFF))
        };
    }

    public static void print(byte[] bytes) {


        for (int i = 0; i < bytes.length; i++) {
            StringBuilder str = new StringBuilder();
            int n = bytes[i]&0xFF;
            int y = n;
            while(y!=0){
                str.append((n&y)>0?"1":"0");
                y>>=1;
                //System.out.println(x + " " + y + " " + (x&y));
            }
            System.out.printf("%s ", String.format("%8s", str).replace(' ', '0'));
        }
        System.out.printf("\n");
    }
}
