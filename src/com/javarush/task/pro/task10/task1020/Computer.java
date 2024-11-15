package com.javarush.task.pro.task10.task1020;

public class Computer {
    private Mouse mouse;
    private Monitor monitor;
    private Keyboard keyboard;
    private SystemUnit systemUnit;

    public Computer() {
        mouse = new Mouse();
        monitor = new Monitor();
        keyboard = new Keyboard();
        systemUnit = new SystemUnit();
    }
}
