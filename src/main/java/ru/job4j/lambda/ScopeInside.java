package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    private static String first = "Гав";
    private static String second = "Му";

    public static void main(String[] args) {
        String ayyyy = "ayyyyy";
        ayyyy = ayyyy + ", People";
        String tmp = ayyyy;
        String name = echo(
                () -> {
                    return tmp;
                }
        );
        System.out.println(ayyyy);
        System.out.println(name);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}
