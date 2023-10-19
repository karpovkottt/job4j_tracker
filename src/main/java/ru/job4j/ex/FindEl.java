package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rls = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rls = i;
                break;
            }
        }
        if (rls == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rls;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"1", "2", "3"}, "0");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
