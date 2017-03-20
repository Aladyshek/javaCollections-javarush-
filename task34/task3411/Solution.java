package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }


    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
        if (count > 1){

               // System.out.printf("%s %d %s %c %s %c%n" , "диск", m, "со столбика",source, "на столбик", destination);


                moveRing((char) (a-1), b, c, count);
                //System.out.printf("%s %d %s %c %s %c%n" , "диск", m, "со столбика",source, "на столбик", destination);

            }



}}