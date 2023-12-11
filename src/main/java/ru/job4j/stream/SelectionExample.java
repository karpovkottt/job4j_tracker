package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("One", "Two", "Three", "Four", "Five");
        String rsl = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("default");
        System.out.println(rsl);
    }
}
