
package models;

import java.util.HashMap;

public class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    private Display display;
    private HashMap<Integer, User> activeUsers;

    public OnlineReaderSystem() {
        userManager = new UserManager();
        library = new Library();
        display = new Display();
        activeUsers = new HashMap<>();
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay(User user) {
        if (activeUsers.get(user.getId()) == null) {
            activeUsers.put(user.getId(), user);
        }
        display.setActiveUser(user);
        return display;
    }

    public Book getActiveBook(User user) {
        User activeUser = activeUsers.get(user.getId());
        if (activeUser == null || activeUser.getActiveBookId() == null) {
            System.out.println("No active book found for user " + user.getName());
            return null;  
        }
        return activeUser.getUserLib().find(user.getActiveBookId());
    }

    public void setActiveBook(User user, Book book) {
        User activeUser = activeUsers.get(user.getId());
        if (activeUser != null) {
            activeUser.setActiveBook(book);
            display.displayBook(user); 
        }
    }

    public boolean addActiveUser(User user) {
        if (activeUsers.containsKey(user.getId())) {
            System.out.println("User is already active.");
            return false; 
        }
        activeUsers.put(user.getId(), user);
        display.displayUser(user);
        return true;
    }

    public boolean removeActiveUser(User user) {
        if (activeUsers.get(user.getId()) == null) {
            System.out.println("User is not active!");
            return false;
        } else {
            activeUsers.remove(user.getId());
        }
        return true;
    }
}
