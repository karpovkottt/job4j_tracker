package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        airbus.showInfo();

        airbus.setName("A380");
        airbus.showInfo();
    }
}
