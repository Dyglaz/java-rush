package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }

    public static void main(String[] args) {
    }

    public static class Thread_1 extends Thread{
        @Override
        public void run() {
            while(true){

            }
        }
    }
    public static class Thread_2 extends Thread{
        @Override
        public void run() {
            try {
                Thread t = new Thread();
                t.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread_3 extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static class Thread_4 extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while(!isInterrupted()){

            }
        }
    }
    public static class Thread_5 extends Thread{
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                int sum = 0;
                while (!(line = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(line);
                }
                System.out.println(sum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}