package ru.job4j.collection;

import java.util.ArrayList;

import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] array : list) {
            for (int num : array) {
                rsl.add(num);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {6, 5, 4});
        list.add(new int[] {3, 2, 1});
        List<Integer> rsl = ConvertList.convert(list);
        for (Integer value : rsl) {
            System.out.print(value + " ");
        }
    }
}
