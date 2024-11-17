package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> filePath = new ArrayList<>();
        Queue<Path> queue = new LinkedList<>();
        Path rootPath = Paths.get(root);

        queue.add(rootPath);

        while(!queue.isEmpty()) {
            Path currentPath = queue.poll();
            try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentPath)){
                for (Path file : directoryStream) {
                    if(Files.isDirectory(file)) {
                        queue.add(file);
                    } else filePath.add(file.toAbsolutePath().toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return filePath;
    }

    public static void main(String[] args) {

    }
}
