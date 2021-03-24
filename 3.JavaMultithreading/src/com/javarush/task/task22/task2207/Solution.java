package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //File file = new File("/Users/pavelsmirnov/Documents/Development/JavaRush/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2207/test_file.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    //System.out.println(words[i]);
                    Pair pair = new Pair();
                    if (result.size() > 0) {
                        for (Pair p : result) {
//                            System.out.println(p.first + " - " + words[i]);
                            if (p.first.equals(words[i])) {
                                pair.first = null;
                                pair.second = null;
                                if (p.first.equals(new StringBuilder(words[i]).reverse().toString())) {
                                    p.second = words[i];
                                }
                                break;
                            }
                            if (p.first.equals(new StringBuilder(words[i]).reverse().toString())) {
                                p.second = words[i];
                                break;
                            }

                            pair.first = words[i];
                            pair.second = null;
                        }
//                        System.out.println(pair.first + " <> " + pair.second);
                    } else {
                        pair.first = words[i];
                        pair.second = null;
                    }

                    if (pair.second == null && pair.first != null)
                        result.add(pair);
                }
            }
        }

//        System.out.println(result.toString());
        result.removeIf(next -> next.second == null);

        //System.out.println(result.toString());
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
