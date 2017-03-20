package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }
    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String letters = "AabcdefghijklmnopqrstuvwxyzBCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // виды символов, цифра, большая буква, малая буква.
        int num = 0;     // есть цифра в пароле
        int mLetter = 0; // есть большая буква в пароле
        int bLetter = 0; // есть малая буква в пароле
        char[] symbols = letters.toCharArray();
        int r;
        // генерю первые 6 символов случайно, не разбирая букв и цифр
        for (int i = 0; i < 6; i++)
        {
            r = (int) (Math.random() * symbols.length);
            if (r <= 26) mLetter = 1;
            else if (r >= 53) num = 1;
            else bLetter = 1;
            // добавили в буфер
            byteArrayOutputStream.write(symbols[r]);
        }
        // седьмой символ
        if ((mLetter + num + bLetter) >= 2) // хотя бы два вида символа уже сгенерились на предыдущих этапах
        {
            r = (int) (Math.random() * symbols.length);
            if (r <= 26) mLetter = 1;
            else if (r >= 53) num = 1;
            else bLetter = 1;
            // добавили в буфер
            byteArrayOutputStream.write(symbols[r]);
        } else
        {
            while ((mLetter + num + bLetter) == 1) // иначе генерим до тех пор пока не получим нужный вид символа
            {
                r = (int) (Math.random() * symbols.length);
                if (r <= 26) mLetter = 1;
                else if (r >= 53) num = 1;
                else bLetter = 1;
                if ((mLetter + num + bLetter) == 2)// два вида символа сгенерились
                    // добавили в буфер
                    byteArrayOutputStream.write(symbols[r]);
            }
        }
        // восьмой символ
        if (((mLetter + num + bLetter) == 3)) // все виды символов уже сгенерились на предыдущих этапах
        {
            r = (int) (Math.random() * symbols.length);
            // добавили в буфер
            byteArrayOutputStream.write(symbols[r]);
        } else
        {
            while ((mLetter + num + bLetter) == 2) // иначе генерим до тех пор пока не получим нужный вид символа
            {
                r = (int) (Math.random() * symbols.length);
                if (r <= 26) mLetter = 1;
                else if (r >= 53) num = 1;
                else bLetter = 1;
                if ((mLetter + num + bLetter) == 3)// три вида символа сгенерились
                    // добавили в буфер
                    byteArrayOutputStream.write(symbols[r]);
            }
        }
        return byteArrayOutputStream;

    }
}