package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor> {
    //напишите тут ваш код
    public int compare(JavaRushMentor x1, JavaRushMentor x2){
        return x1.getName().length() - x2.getName().length();
    }
}
