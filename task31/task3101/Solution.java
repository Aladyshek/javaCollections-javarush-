package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path folderName = Paths.get(args[0]);
        Path finalFilePath = Paths.get(args[1]);
//Собираю валидные файлы
        List<File> list = iterateFolder(folderName, finalFilePath);
//Сортирую
        Collections.sort(list, (f1, f2) -> f1.getName().compareTo(f2.getName()));
//Записываю содержимое в файл
        File resultFile = finalFilePath.toFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(resultFile, true));
        for (File file : list) {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while (in.ready()) {
                out.write(in.read());
            }
            out.write(System.lineSeparator());
            in.close();
        }
        out.close();
//Переименовываю
        File allFilesContent = new File(resultFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFile, allFilesContent);
    }

    private static List<File> iterateFolder(Path filePath, Path resultFileAbsolutePath) throws IOException {
        List<File> list = new ArrayList<>();
        Files.walkFileTree(filePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                if (!filePath.equals(resultFileAbsolutePath)) {
                    File file = filePath.toFile();
                    if (file.length() > 50) {
                        FileUtils.deleteFile(file);
                    } else {
                        list.add(file);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return list;
    }
}
