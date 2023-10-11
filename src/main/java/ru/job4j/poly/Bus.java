package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Количество пассажиров в автобусе: " + quantity);
    }

    @Override
    public double fuelRefill(double quantity) {
        double price = 52.96;
        return quantity * price;
    }
}
