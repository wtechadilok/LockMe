package org.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directory {
    private List<File> files;
    public String directoryName;

    public Directory(String folderPath) {
        directoryName = folderPath;
        //create instance of the FileSystems. Converting the directory path to the absolute path.
        Path path = FileSystems.getDefault().getPath(directoryName).toAbsolutePath();
        //read the folder
        File folder = path.toFile();
        //read all the files in the folder
        File[] dirFiles = folder.listFiles();
        //store files into the list
        files = new ArrayList<>(Arrays.asList(dirFiles));
        Collections.sort(files);
    }

    public List<File> getSortedFiles() {
        return files;
    }

    public void printFiles() {
        System.out.println("All files in " + directoryName);
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * Add the file to the current directory
     *
     * @param fileName the name of the file to add
     * @return True if file is new and successfully added. False otherwise.
     */
    public boolean addFile(String fileName) {
        Path path = FileSystems.getDefault().getPath(directoryName + fileName).toAbsolutePath();
        File f = path.toFile();
        try {
            if (f.createNewFile()) {
                files.add(f);
                Collections.sort(files);
                System.out.println("File successfully created.");
                return true;
            } else {
                System.out.println("File already existed.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("IO exception occurred.");
            return false;
        }
    }

    public static void main(String[] args) {
        Directory d = new Directory("../Storage/");
        System.out.println("------------------------");
        System.out.println("Print all files in sorting order.");
        d.printFiles();
        System.out.println("------------------------");
        System.out.println("Adding a new file.");
        d.addFile("Test3.txt");
        System.out.println("------------------------");
        System.out.println("Print all files in sorting order.");
        d.printFiles();
    }
}
