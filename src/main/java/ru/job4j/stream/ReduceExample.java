package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = list.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());

        List<String> strings = List.of("one", "two", "three");
        Optional<String> str = strings.stream()
                .reduce((a, b) -> a + " " + b);
        System.out.println(str.get());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int sumNums = nums.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sumNums);

        List<Person> people = Arrays.asList(
                new Person("Mich", 35),
                new Person("Nic", 16),
                new Person("Lily", 26),
                new Person("Foma", 30)
        );
        int sumOld = people.stream()
                .reduce(
                        0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b
                        );
        System.out.println(sumOld);
    }
}
