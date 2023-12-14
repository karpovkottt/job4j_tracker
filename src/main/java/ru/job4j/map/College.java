package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(e -> e.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String accountNumber, String name) {
        var account = findByAccount(accountNumber);
        if (account.isPresent()) {
            return students.get(account.get())
                    .stream()
                    .filter(e -> e.name().equals(name))
                    .findFirst();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> optional = college.findByAccount("000001");
        if (optional.isPresent()) {
            System.out.println("Найденный студент: " + optional.get());
        } else {
            System.out.println("Студент не найден");
        }
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        if (english.isPresent()) {
            System.out.println("Оценка по найденному предмету: " + english.get().score());
        } else {
            System.out.println("Not found");
        }
    }
}
