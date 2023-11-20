package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class SortItemByNameTest {
    @Test
    public void whenSortItemByNameAscending() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Nikolay"),
                new Item("Fedor")
        );
        List<Item> expected = Arrays.asList(
                new Item("Fedor"),
                new Item("Ivan"),
                new Item("Nikolay"),
                new Item("Petr")
                );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortItemByNameDescending() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Nikolay"),
                new Item("Fedor")
        );
        List<Item> expected = Arrays.asList(
                new Item("Petr"),
                new Item("Nikolay"),
                new Item("Ivan"),
                new Item("Fedor")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}