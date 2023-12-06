package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                0, -2, 2, 5, 8, 10, -3, -5, 0
        );
        List<Integer> positive = numbers.stream().filter(
                num -> num > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
