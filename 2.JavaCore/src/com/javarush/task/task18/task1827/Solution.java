package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static class Product {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;


        switch (args[0]) {
            case "-c":
                BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
                String fileName = file.readLine();
                List<Product> products = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    while (reader.ready()) {
                        products.add(strToProduct(reader.readLine()));
                    }
                } catch (IOException ignored) {
                }
                int id = 0;
                for (Product product : products) {
                    if (product.id > id) id = product.id;
                }
                String name = "";
                for (int i = 1; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product product = new Product(++id, name.trim(), price, quantity);
                products.add(product);


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

                    for (Product p : products) {
                        writer.write(p.toString());
                        writer.write("\n");
                    }
                }catch (IOException ignored){}
                break;
        }
    }

    private static Product strToProduct(String str) {
        int id = Integer.parseInt(str.substring(0, 8).trim());
        String productName = str.substring(8, 38).trim();
        String price = str.substring(38, 46).trim();
        String quantity = str.substring(46,50).trim();
        return new Product(id, productName, price, quantity);
    }
}
