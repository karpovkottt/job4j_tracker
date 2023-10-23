package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "one", "1"
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "1"
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiplyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "1", "2", "3"
                }
        );
        ValidateInput input = new ValidateInput(out, in);
        for (int i = 1; i <= 3; i++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(i);
        }
    }

    @Test
    void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}