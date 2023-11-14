package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodThenFalse() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("2f44a", "Petr Arsentev"));
        boolean result = office.add(new Citizen("2f44a", "PP"));
        assertThat(result).isFalse();
    }
}