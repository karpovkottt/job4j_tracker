package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAscending() {
        List<Job> jobs = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix bugs", 1),
                new Job("Refactor", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bugs", 1),
                new Job("Refactor", 2),
                new Job("Task", 0)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenComparatorByNameDescending() {
        List<Job> jobs = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix bugs", 1),
                new Job("Refactor", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Task", 0),
                new Job("Refactor", 2),
                new Job("Fix bugs", 1)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenComparatorByPriorityAscending() {
        List<Job> jobs = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix bugs", 1),
                new Job("Refactor", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix bugs", 1),
                new Job("Refactor", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenComparatorByPriorityDescending() {
        List<Job> jobs = Arrays.asList(
                new Job("Task", 0),
                new Job("Fix bugs", 1),
                new Job("Refactor", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Refactor", 2),
                new Job("Fix bugs", 1),
                new Job("Task", 0)

        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs).containsSequence(expected);
    }

    @Test
    public void whenComparatorByNameAndPriorityDescending() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorBySameNameAndPriorityDescending() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAscending() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorBySameNameAndPriorityAscending() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}