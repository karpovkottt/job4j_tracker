package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", 464);
        Book book2 = new Book("Java 8", 560);
        Book book3 = new Book("Java for everyone", 480);
        Book book4 = new Book("Code complete", 889);
        Book[] books = new Book[] {book1, book2, book3, book4};
        for (Book bk : books) {
            System.out.println("Книга: " + bk.getName() + ", кол-во страниц: " + bk.getPages());
        }
        System.out.println("Replace book1 and book4.");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (Book bk : books) {
            System.out.println("Книга: " + bk.getName() + ", кол-во страниц: " + bk.getPages());
        }
        System.out.println("Display only \"Clean Code\" book.");
        for (Book bk : books) {
            if ("Clean Code".equals(bk.getName())) {
                System.out.println("Книга: " + bk.getName() + ", кол-во страниц: " + bk.getPages());
            }
        }
    }
}
