package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .flatMap(Stream::ofNullable)
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }
}
