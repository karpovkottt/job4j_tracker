package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("Element could not be null");
        }
        int rls = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rls = i;
                break;
            }
        }
        return rls;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"1", "2", "3"}, "3");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
