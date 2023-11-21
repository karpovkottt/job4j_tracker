package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] str1 = left.split("\\.");
        String[] str2 = right.split("\\.");
        return Integer.compare(Integer.parseInt(str1[0]), Integer.parseInt(str2[0]));
    }
}
