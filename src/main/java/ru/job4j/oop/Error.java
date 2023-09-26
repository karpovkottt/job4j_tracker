package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Есть ошибка: " + active);
        System.out.println("Код ответа: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        System.out.println();
        Error error2 = new Error(true, 404, "Page not found");
        error2.printInfo();
        System.out.println();
        Error error3 = new Error(false, 200, "OK");
        error3.printInfo();
    }
}
