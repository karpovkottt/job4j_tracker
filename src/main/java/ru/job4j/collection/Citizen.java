package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) object;
        return Objects.equals(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
