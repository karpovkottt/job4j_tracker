package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("karpov.kottt@gmail.com", "Karpov Konstantin");
        map.put("karpov.k@list.ru", "Karp Kottt");
        map.put("karp.kottt@mail.ru", "Kosta Karpetio");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
