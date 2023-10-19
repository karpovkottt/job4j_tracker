package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenFactN1Then1() {
        int n = 1;
        int expected = 1;
        int result = new Fact().calc(n);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenFactN3Then6() {
        int n = 3;
        int expected = 6;
        int result = new Fact().calc(n);
        assertThat(result).isEqualTo(expected);
    }
}