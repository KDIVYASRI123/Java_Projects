package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private HashMap<Integer, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public Boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            return false;
        }
        books.put(book.getId(), book);
        return true;
    }

    public boolean remove(Book b) {
        return remove(b.getId());
    }

    public boolean remove(int id) {
        if (!books.containsKey(id)) {
            return false;
        }
        books.remove(id);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public HashMap<Integer, Book> getBooks() {
        return books;
    }

    public void printAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book.toString());
        }
    }
}
