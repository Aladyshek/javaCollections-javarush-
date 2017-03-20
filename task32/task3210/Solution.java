package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Используем RandomAccessFile
*/
public class Solution {
    public static void main(String... args) throws FileNotFoundException,IOException {
        if (args != null && args.length == 3) {
            String fileName = args[0];
            long number = Integer.parseInt(args[1]);
            String text = args[2];
            byte[] bt = new byte[text.length()];
            try {
                RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
                int end = args[2].length();
                int beg = Integer.parseInt(args[1]);
                byte[] bytes = new byte[end];
                raf.seek(beg);
                raf.read(bytes, 0, end);
                String tmp = convertByteToString(bytes);
                String answer;
                if (tmp.equals(args[2])) {
                    answer = "true";
                } else {
                    answer = "false";
                }
                raf.seek(raf.length());
                raf.write(answer.getBytes());


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



    private static String convertByteToString(byte[] bt) {
        return new String(bt);
    }


}