package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        int doInt = file.getName().lastIndexOf(".");
        if(file.isDirectory()
                || file.getName().substring(doInt).equalsIgnoreCase(".html")
                || file.getName().substring(doInt).equalsIgnoreCase(".htm")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
