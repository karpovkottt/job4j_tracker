package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от одного до трех: ");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= 3 && count >= matches) {
                turn = !turn;
                count -= matches;
                System.out.println("На столе осталось: " + count + " спичек");
            } else {
                System.out.println("Число должно быть в диапазоне от 1 до 3 и не больше остатка спичек на столе");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
