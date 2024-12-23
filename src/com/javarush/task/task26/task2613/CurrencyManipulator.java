package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new TreeMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int total = 0;
        for (Integer denomination : denominations.keySet()) {
            total += denomination * denominations.get(denomination);
        }
        return total;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

}
