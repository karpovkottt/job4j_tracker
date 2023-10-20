package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rls = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(key)) {
                rls = i;
                break;
            }
        }
        if (rls == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rls;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String val : abuses) {
            if (value.equals(val)) {
                throw new ElementAbuseException("Value not allowed");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"1", "2", "3"}, "0");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
