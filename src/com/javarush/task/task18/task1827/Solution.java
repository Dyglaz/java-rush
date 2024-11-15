package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {


    public static class Product{

        private int id;
        private String name;
        private String price;
        private String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }

        public int getId() {
            return id;
        }
    }



    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        List<Product> products = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while(bufferedReader.ready()){
                String lineProduct = bufferedReader.readLine();
                products.add(getProduct(lineProduct));
            }
        }

        if(args[0].equals("-c")){

            int id = 0;
            for (Product product : products) {
                if (product.id > id) id = product.id;
            }

            Product newProduct = new Product(++id, args[1], args[2], args[3]);
            try(FileWriter fileWriter = new FileWriter(fileName, true)){
                fileWriter.write("\n");
                fileWriter.write(newProduct.toString());
            }
        }

        reader.close();

    }

    public static Product getProduct(String product){
        int id = Integer.parseInt(product.substring(0, 8).trim());
        String name = product.substring(8, 38).trim();
        String price = product.substring(38, 46).trim();
        String quantity = product.substring(46, 50).trim();
        return new Product(id, name, price, quantity);
    }
}
