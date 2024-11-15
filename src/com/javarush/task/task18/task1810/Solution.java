package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                FileInputStream inputStream = new FileInputStream(reader.readLine());
                if(inputStream.available() < 1000){
                    inputStream.close();
                    throw new DownloadException();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static class DownloadException extends Exception {

    }
}
