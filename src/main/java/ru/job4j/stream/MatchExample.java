package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        boolean rsl = strings.stream()
                .noneMatch("six"::contains);
        System.out.println(rsl);
        boolean rsl2 = strings.stream()
                .anyMatch(e -> e.endsWith("r"));
        System.out.println(rsl2);
        List<String> strings2 = Arrays.asList("time", "two", "three", "twix");
        boolean rsl3 = strings2.stream()
                .allMatch(e -> e.startsWith("t"));
        System.out.println(rsl3);
    }
}
