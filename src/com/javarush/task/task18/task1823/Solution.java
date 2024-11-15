package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            while(!(str = reader.readLine()).equals("exit")){
                ReadThread readThread = new ReadThread(str);
                readThread.start();
            }
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] byteCountArray = new int[256];
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                while (fileInputStream.available() > 0) {
                    byteCountArray[fileInputStream.read()] += 1;
                }

                int max = Arrays.stream(byteCountArray).max().getAsInt();
                Set<Integer> setInt = new HashSet<>();
                for (int i = 0; i < byteCountArray.length; i++) {
                    if(byteCountArray[i] == max){
                        setInt.add(i);
                    }
                }
                if(setInt.size() > 1){
                    resultMap.put(fileName, Collections.min(setInt));
                } else if (setInt.size() == 1){
                    resultMap.put(fileName, setInt.iterator().next());
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
