package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + "spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        System.out.println("Фильтрация-->с помощью Stream<--");
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        System.out.println("\n-->тоже с помощью цикла<--");
        List<Task> container = new ArrayList<>();
        for (Task task : tasks) {
            if (task.name.contains("Bug")) {
                container.add(task);
            }
        }
        container.forEach(System.out::println);

        System.out.println("\nПреобразование-->с помощью Stream<--");
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("\n-->тоже с помощью цикла<--");
        List<String> container2 = new ArrayList<>();
        for (Task task : tasks) {
            container2.add(task.name);
        }
        container2.forEach(System.out::println);

        System.out.println("\nУпрощение-->с помощью Stream<--");
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);
        System.out.println(total);

        System.out.println("\n-->тоже с помощью цикла<--");
        total = 0L;
        for (Task task : tasks) {
            total += task.spent;
        }
        System.out.println(total);

        System.out.println("\nАккумуляция-->с помощью Stream<--");
        List<Task> bugs2 = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs2.forEach(System.out::println);
    }
}
