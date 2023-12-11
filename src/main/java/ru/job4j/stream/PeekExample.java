package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Michael"), new StringBuilder("Alex"), new StringBuilder("Petr")
        );
        List<StringBuilder> editedNames = names
                .stream()
                .peek(el -> el.append(" Student Job4J"))
                .sorted()
                .toList();
        System.out.println(editedNames);
    }
}
