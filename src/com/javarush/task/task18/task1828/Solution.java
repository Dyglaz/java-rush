package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {


    public static class Product{

        public int id;
        public String name;
        public String price;
        public String quantity;

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

        if(args[0].equals("-u")){

            Product newProduct = new Product(Integer.parseInt(args[1]), args[2], args[3], args[4]);
            for(Product p : products){
                if(newProduct.getId() == p.getId()){
                    p.name = newProduct.name;
                    p.price = newProduct.price;
                    p.quantity = newProduct.quantity;
                }
            }

        } else if(args[0].equals("-d")){
            int idProd = Integer.parseInt(args[1]);
            List<Product> deleteProducts = new ArrayList<>();
            for(Product p : products){
                if(p.getId() == idProd){
                    deleteProducts.add(p);
                }
            }
            products.removeAll(deleteProducts);
        }

        try(FileWriter fileWriter = new FileWriter(fileName)){
            for(Product p : products){
                fileWriter.write(p.toString() + "\n");
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
