package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        //List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            int counter = 0;
            for (String el : value.split("/")) {
                if (counter == 0) {
                    start += el;
                    tmp.add(start);
                    counter++;
                } else {
                    start += "/" + el;
                    tmp.add(start);
                }
            }
        }
        //return rsl;
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
