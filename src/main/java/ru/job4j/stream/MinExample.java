package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.*;
import java.util.stream.IntStream;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 1, 2, 3);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());

        OptionalInt min = IntStream
                .rangeClosed(1, 5)
                        .min();
        System.out.println(min.getAsInt());

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::getAge));
        int age = youngestPerson.get().getAge();
        System.out.println(age);
    }
}
