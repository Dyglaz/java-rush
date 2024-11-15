package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Iphone other = (Iphone) obj;
        if (this.price != other.price) return false;
        if (this.model == null && this.color == null) return other.model == null && other.color == null;
        if (this.model == null && other.model != null) return false;
        if (this.color == null && other.color != null) return false;
        return Objects.equals(this.model, other.model) && this.color.equals(other.color);
    }


    //напишите тут ваш код

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
