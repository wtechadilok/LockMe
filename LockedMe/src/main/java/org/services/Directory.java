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
     * @param filename the name of the file to add
     * @return True if file is new and successfully added. False otherwise.
     */
    public boolean addFile(String filename) {
        Path path = FileSystems.getDefault().getPath(directoryName + filename).toAbsolutePath();
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
            System.out.println("IOException occurred.");
            return false;
        }
    }

    /**
     * Delete the file specified by the filename from the current directory.
     *
     * @param filename the name of the file to delete
     * @return True if file is existing and successfully deleted. False otherwise.
     */
    public boolean deleteFile(String filename) {
        Path path = FileSystems.getDefault().getPath(directoryName + filename).toAbsolutePath();
        File f = path.toFile();
        if (f.delete()) {
            files.remove(f);
            System.out.println("File successfully deleted.");
            return true;
        } else {
            System.out.println("File failed to delete. Check your spelling.");
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
        System.out.println("------------------------");
        System.out.println("Delete a file.");
        d.deleteFile("Test2.txt");
        System.out.println("------------------------");
        System.out.println("Print all files in sorting order.");
        d.printFiles();
    }
}
