package com.javarush.task.task18.task1828;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Прайсы 2
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
            return String.format("%-8d%-30s%-8s%-4s\n", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        List<Product> productList = new ArrayList<>();
        while (file.ready()) {
            productList.add(getProduct(file.readLine()));
        }
        reader.close();
        file.close();
        switch (args[0]) {
            case "-u":
                int newId = Integer.parseInt(args[1]);
                String newName = "";
                //= args[2].substring(0,30).trim();
                //String price = args[3].substring(0, 8).trim();
                //String quantity = args[4].substring(0, 4).trim();

                for (int i = 2; i < args.length - 2; i++) {
                    newName += args[i] + " ";
                }
                if (newName.length() > 30) {
                    newName = newName.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }

                Product updateProduct = null;

                for (Product p: productList) {
                    if (p.id == newId) updateProduct = p;
                }
                if(updateProduct != null){
                    updateProduct.productName = newName;
                    updateProduct.price = price;
                    updateProduct.quantity = quantity;
                }

                break;
            case "-d":
                productList.removeIf(x -> x.id == Integer.parseInt(args[1]));
                break;
        }

        FileWriter writeFile = new FileWriter(fileName);
        productList.forEach((product) -> {
            try {
                writeFile.write(product.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writeFile.close();

    }

    public static Product getProduct(String str) {
        int id = Integer.parseInt(str.substring(0, 8).trim());
        String name = str.substring(8, 38).trim();
        String price = str.substring(38, 46).trim();
        String quantity = str.substring(46, 50).trim();

        return new Product(id, name, price, quantity);
    }
}
