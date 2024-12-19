package main;

import models.Book;
import models.Bookshelf;
import models.OnlineReaderSystem;
import models.User;

public class Main {
    public static void main(String[] args) {
        OnlineReaderSystem onlineReaderSystem = new OnlineReaderSystem();

        Book dsBook = new Book(1, "It contains Data Structures", "Ds");
        Book algoBook = new Book(2, "It contains Algorithms", "Algo");
        Book javaBook = new Book(3, "It covers Java programming", "Java");

        onlineReaderSystem.getLibrary().addBook(dsBook);
        onlineReaderSystem.getLibrary().addBook(algoBook);
        onlineReaderSystem.getLibrary().addBook(javaBook);

        System.out.println("\n--- All Books Added ---");
        onlineReaderSystem.getLibrary().printAllBooks();

        User user1 = new User(1, "Basic user details", "Ram");
        User user2 = new User(2, "Basic user details", "Gopal");

        onlineReaderSystem.getUserManager().addUser(user1);
        onlineReaderSystem.getUserManager().addUser(user2);

        Bookshelf currentlyReading1 = new Bookshelf("Currently Reading");
        Bookshelf completed1 = new Bookshelf("Completed");
        Bookshelf favorites1 = new Bookshelf("Favorites");

        Bookshelf currentlyReading2 = new Bookshelf("Currently Reading");
        Bookshelf completed2 = new Bookshelf("Completed");
        Bookshelf favorites2 = new Bookshelf("Favorites");

        user1.addBookshelf(currentlyReading1);
        user1.addBookshelf(completed1);
        user1.addBookshelf(favorites1);

        user2.addBookshelf(currentlyReading2);
        user2.addBookshelf(completed2);
        user2.addBookshelf(favorites2);

        System.out.println("\n--- User 1 (Ram) logs in and starts reading ---");
        onlineReaderSystem.getUserManager().login(1);
        onlineReaderSystem.addActiveUser(user1);
        onlineReaderSystem.setActiveBook(user1, dsBook);
        onlineReaderSystem.getDisplay(user1).turnPageForward();
        onlineReaderSystem.getDisplay(user1).turnPageForward();
        onlineReaderSystem.getDisplay(user1).turnPageBackward();
        onlineReaderSystem.getDisplay(user1).showReadingProgress();

        System.out.println("\n--- User 1 (Ram) adds bookmarks ---");
        user1.addBookmark(5);
        user1.addBookmark(15);
        user1.viewBookmarks();

        System.out.println("\n--- User 1 (Ram) rates the Data Structures book ---");
        dsBook.rateBook(4);

        System.out.println("\n--- User 1 (Ram) adds books to bookshelves ---");
        currentlyReading1.addBook(dsBook);
        completed1.addBook(algoBook);
        favorites1.addBook(javaBook);

        user1.viewBooksInShelf("Currently Reading");
        user1.viewBooksInShelf("Completed");
        user1.viewBooksInShelf("Favorites");

 System.out.println("\n--- User 1 (Ram) updates profile ---");
        user1.updateProfile("RAMU", "Updated details");

        onlineReaderSystem.getUserManager().logout(1);

       
    }
}
