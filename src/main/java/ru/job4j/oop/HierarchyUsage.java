package ru.job4j.oop;

import java.util.Objects;

public class HierarchyUsage {
    public static void main(String[] args) {
        /* создаем объект класса Automobile */
        Automobile auto = new Automobile();
        /* делаем приведение к типу родителя Transport (повышающее приведение) */
        Transport tp = auto;
        /* делаем приведение к типу родителя Object (повышающее приведение) */
        Object obj = auto;
        /* приведение типа при создании объекта */
        Object oauto = new Automobile();
        /* приведение типа за счет понижения в иерархии */
        Automobile autoFromObject = (Automobile) oauto;

        Object bicycle = new Bicycle();
        /* неверное приведение типов */
        // Automobile cb = (Automobile) bicycle;

        System.out.println(new Automobile());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}
