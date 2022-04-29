package org.services;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directory {
    private List<File> files;
    public static final String directoryName = "../Storage/";

    public Directory() {
        //create instance of the FileSystems. Converting the directory path to the absolute path.
        Path path = FileSystems.getDefault().getPath(directoryName).toAbsolutePath();
        //read the folder
        File folder = path.toFile();
        //read all the files in the folder
        File[] dirFiles = folder.listFiles();
        //store files into the list
        files = Arrays.asList(dirFiles);
        Collections.sort(files);
    }

    public List<File> getSortedFiles(){
        return files;
    }

    public void printFiles(){
        System.out.println("All files in " + directoryName);
        for (File f : files) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        Directory d = new Directory();
        d.printFiles();
    }
}
