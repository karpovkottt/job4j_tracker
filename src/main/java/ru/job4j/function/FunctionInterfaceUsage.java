package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        /**
         * Функциональный интерфейс Supplier, Consumer, BiConsumer
         */
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = supplier.get();
        int counter = 1;
        for (String s : strings) {
            biConsumer.accept(counter++, " is " + s);
        }
        Supplier<String> sup = () -> "New string for interface";
        BiConsumer<String, String> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(sup.get(), " and second string");
        /**
         * Функциональный интерфейс Predicate, BiPredicate
         */
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
        /**
         * Функциональный интерфейс Function, BiFunction
         */
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        BiFunction<String, Integer, String> biFunc = (s, i) -> s.concat(" ").concat(i.toString());
        System.out.println("Результат работы биФункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы биФункции: " + biFunc.apply("String number:", 123));
        /**
         * Функциональный интерфейс UnaryOperator, BinaryOperator
         */
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> biBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println("Строка после объединения: "
                + biBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
