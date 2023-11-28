package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("Image 1", 20),
                new Attachment("Image 3", 120),
                new Attachment("Image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            return Integer.compare(left.getSize(), right.getSize());
        };
        Arrays.sort(atts, comparator);
        System.out.println(Arrays.toString(atts));
        Comparator<String> cmpSize = (left, right) -> Integer.compare(left.length(), right.length());
        String[] strings = {"cdefg", "bcd", "abcd"};
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(strings, cmpText);
        System.out.println(Arrays.toString(strings));
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(strings, cmpDescSize);
        System.out.println(Arrays.toString(strings));
    }
}
