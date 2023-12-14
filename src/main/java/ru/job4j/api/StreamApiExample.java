package ru.job4j.api;

import java.util.List;
import java.util.stream.Stream;

public class StreamApiExample {
    public static void main(String[] args) {
        System.out.println("takeWhile");
        List.of(1, 2, 3, 4, 5).stream()
                .takeWhile(e -> e < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);

        System.out.println("dropWhile");
        List.of(1, 2, 3, 4, 5, 2, 1).stream()
                .dropWhile(e -> e < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);

        System.out.println("Stream.ofNullable");
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }
}
