package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = null;
        try {
            sw = new StringWriter();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                sw.write(br.readLine());
            }
            br.close();


        } catch (Exception e) {
            if (is == null) {
            }
        }
        return sw;
    }
}
