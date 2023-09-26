package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    public Computer(boolean multiMonitor, int ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer() {

    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " Gb");
        System.out.println("Модель CPU: " + cpu);
    }

    public static void main(String[] args) {
        Computer computer = new Computer(true, 500, "Intel i7");
        computer.printInfo();
        System.out.println();
        Computer comp = new Computer(true, 256, "AMD Ryzen 5 3600");
        comp.printInfo();
        System.out.println();
        Computer comp2 = new Computer();
        comp2.printInfo();
    }
}
