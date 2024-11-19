package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        Queue<Path> queue = new LinkedList<>();

        File resultFile = new File(resultFileAbsolutePath);
        File dest = new File(resultFile.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(dest)){
            FileUtils.deleteFile(dest);
        }
        FileUtils.renameFile(resultFile, dest);

        Path rootPath = Paths.get(path);
        queue.add(rootPath);

        while(!queue.isEmpty()) {
            Path currentPath = queue.poll();
            try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentPath)){
                for (Path pathFile : directoryStream) {
                    if(Files.isDirectory(pathFile)) {
                        queue.add(pathFile);
                    } else {
                        if (pathFile.toFile().length() <= 50){
                            try(FileOutputStream fileOutputStream = new FileOutputStream(dest)){
                                byte[] bytes = Files.readAllBytes(pathFile);
                                fileOutputStream.write(bytes);
                                fileOutputStream.write(System.lineSeparator().getBytes());
                                fileOutputStream.flush();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
