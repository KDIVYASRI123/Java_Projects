package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String details;
    private Library userLib;
    private Integer activeBookId;
    private List<Bookshelf> bookshelves;  
    private List<Integer> bookmarkedPages;  

    public User(int id, String details, String name) {
        this.userId = id;
        this.details = details;
        this.name = name;
        this.activeBookId = null;
        this.userLib = new Library();
        this.bookshelves = new ArrayList<>();  
        this.bookmarkedPages = new ArrayList<>();  
    }

    public int getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Library getUserLib() {
        return this.userLib;
    }

    public Integer getActiveBookId() {
        if (this.activeBookId == null) {
            System.out.println("User has no active book!");
            return null;
        }
        return this.activeBookId;
    }

    public void setActiveBook(Book book) {
        if (this.userLib.find(book.getId()) == null)
            this.userLib.addBook(book);
        this.activeBookId = book.getId();
    }

    public void addBookmark(int pageNum) {
        if (!bookmarkedPages.contains(pageNum)) {
            bookmarkedPages.add(pageNum);
            System.out.println("Page " + pageNum + " bookmarked.");
        }
    }

    public void removeBookmark(int pageNum) {
        bookmarkedPages.remove(Integer.valueOf(pageNum));
        System.out.println("Page " + pageNum + " removed from bookmarks.");
    }

    public void viewBookmarks() {
        if (bookmarkedPages.isEmpty()) {
            System.out.println("No bookmarked pages.");
        } else {
            System.out.println("Bookmarked Pages: ");
            for (int page : bookmarkedPages) {
                System.out.println("Page " + page);
            }
        }
    }

    public void addBookshelf(Bookshelf bookshelf) {
        bookshelves.add(bookshelf);
    }

    public void removeBookshelf(String category) {
        bookshelves.removeIf(bookshelf -> bookshelf.getCategory().equalsIgnoreCase(category));
    }

    public void viewBookshelves() {
        System.out.println("Bookshelves for " + name + ":");
        for (Bookshelf shelf : bookshelves) {
            System.out.println("- " + shelf.getCategory());
        }
    }

    public void viewBooksInShelf(String category) {
        for (Bookshelf shelf : bookshelves) {
            if (shelf.getCategory().equalsIgnoreCase(category)) {
                shelf.viewBooks();
                return;
            }
        }
        System.out.println("No bookshelf found with category " + category);
    }

    public void updateProfile(String newName, String newDetails) {
        this.name = newName;
        this.details = newDetails;
        System.out.println("Profile updated: Name - " + newName + ", Details - " + newDetails);
    }
}
