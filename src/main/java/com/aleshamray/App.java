package com.aleshamray;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Set<String> files=new HashSet<>();
        listOfPackage("src/main/java/com/aleshamray/",files);

        files.stream().forEach(System.out::println);
    }

    public static void listOfPackage(String directoryName, Set<String> pack) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                String path=file.getPath();
                String packName=path.substring(path.indexOf("java")+5, path.lastIndexOf('/'));
                pack.add(packName.replace('/', '.'));
            } else if (file.isDirectory()) {
                listOfPackage(file.getAbsolutePath(), pack);
            }
        }
    }
}