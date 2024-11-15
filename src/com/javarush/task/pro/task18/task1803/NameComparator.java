package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor> {
    public int compare(JavaRushMentor o1, JavaRushMentor o2) {
        if(o1.getName().length() > o2.getName().length()){
            return 1;
        } else if (o1.getName().length() < o2.getName().length()){
            return -1;
        } else if (o1.getName().length() == o2.getName().length()){
            return 0;
        } else return o1.getName().compareTo(o2.getName());
    }
}
