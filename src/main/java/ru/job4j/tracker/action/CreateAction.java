package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Добавить новую заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
