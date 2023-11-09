package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> nums = new HashSet<>();
        for (Task task : tasks) {
            nums.add(task.getNumber());
        }
        return nums;
    }

    public static void main(String[] args) {
        FullSearch fullSearch = new FullSearch();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "first"));
        tasks.add(new Task("1", "first"));
        tasks.add(new Task("2", "second"));
        tasks.add(new Task("3", "second"));
        Set<String> rsl = fullSearch.extractNumber(tasks);
        for (String value : rsl) {
            System.out.println(value);
        }
    }
}
