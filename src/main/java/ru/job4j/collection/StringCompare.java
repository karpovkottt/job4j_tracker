package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return -1;
            }
            if (left.charAt(i) > right.charAt(i)) {
                return 1;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
