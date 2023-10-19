package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindElTest {

    @Test
    public void whenException() {
        ElementNotFoundException exception = assertThrows(
                ElementNotFoundException.class,
                () -> {
                    FindEl.indexOf(new String[] {"1", "2", "3"}, "4");
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Element not found");
    }

    @Test
    public void whenStrArrValABCKeyBThen1() throws ElementNotFoundException {
        String[] value = new String[] {"A", "B", "C"};
        String key = "B";
        int expected = 1;
        int result = FindEl.indexOf(value, key);
        assertThat(result).isEqualTo(expected);
    }
}