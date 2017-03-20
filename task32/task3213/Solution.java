package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static final int A_LOWER = 97;
    public static final int Z_LOWER = 122;
    public static final int A_UPPER = 65;
    public static final int Z_UPPER = 90;
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr CcaA? Wd34d2`km=\\.;");
        System.out.println(decode(reader, -3));  //Hello Amigo
        reader.reset();
        System.out.println(decode(reader, 5));  //Hello Amigo
        reader.reset();
        System.out.println(decode(reader, 23));  //Hello Amigo
        reader.reset();
        System.out.println(decode(reader, -55));  //Hello Amigo
        reader.reset();
        System.out.println(decode(reader, 0));  //Hello Amigo
    }
    public static String decode(StringReader reader, int key) {
        if (reader == null) {
            return "";
        }
        try {
            key %= 26;
            StringWriter writer = new StringWriter();
            int read;
            while (reader.ready() && (read = reader.read()) != -1) {
                writer.write(letter(read, key));
            }
            return writer.toString();
        }catch (Exception e) {
            return "";
        }
    }
    private static char letter(int c, int key) {
        int newChar = c + key;

        return (char) newChar;
    }

}
