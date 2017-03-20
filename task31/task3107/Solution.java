package com.javarush.task.task31.task3107;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {

    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path p= Paths.get(pathToFile);
            fileData =new ConcreteFileData(Files.isHidden(p),Files.isExecutable(p),Files.isDirectory(p),Files.isWritable(p));
        } catch (Exception e) {
            fileData =new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}