package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);

        try(FileInputStream fileInputStream = new FileInputStream(path.toFile())){
            if (getExtension(path).equals("xml")) {
                properties.loadFromXML(fileInputStream);
            } else {
                properties.load(fileInputStream);
            }
        } catch (IOException e) {

        }
        return properties;
    }

    private String getExtension(Path path){
        String absolutePath = path.toAbsolutePath().toString();
        int index = absolutePath.lastIndexOf(".");
        if(index != -1){
            return absolutePath.substring(index+1);
        } else {
            return absolutePath;
        }
    }
}
