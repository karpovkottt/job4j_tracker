package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(first, add(second, third));
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        System.out.println("Результат выполнения статического метода sum: " + result);
        result = calculator.multiply(10);
        System.out.println("Результат выполнения нестатического метода multiply: " + result);
        result = minus(10);
        System.out.println("Результат выполнения статического метода minus: " + result);
        result = calculator.divide(10);
        System.out.println("Результат выполнения нестатического метода divide: " + result);
        result = calculator.sumAllOperation(10);
        System.out.println("Результат выполнения нестатического метода sumAllOperation: " + result);
    }
}
