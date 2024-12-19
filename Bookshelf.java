package models;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private String category;
    private List<Book> books;

    public Bookshelf(String category) {
        this.category = category;
        this.books = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            System.out.println("Book " + book.getTitle() + " added to " + category + " shelf.");
        } else {
            System.out.println("Book " + book.getTitle() + " is already in " + category + " shelf.");
        }
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Book " + book.getTitle() + " removed from " + category + " shelf.");
        } else {
            System.out.println("Book " + book.getTitle() + " is not in " + category + " shelf.");
        }
    }

    public void viewBooks() {
        System.out.println("Books in " + category + " shelf:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        }
    }
}
