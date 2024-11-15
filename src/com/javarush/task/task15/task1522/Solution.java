package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        else if (str.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
        else if (str.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        else thePlanet = null;
    }
}
