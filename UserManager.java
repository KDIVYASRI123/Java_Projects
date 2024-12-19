package models;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public Boolean addUser(User user) {
        if (users.containsKey(user.getId())) {
            return false;
        }
        users.put(user.getId(), user);
        return true;
    }

    public User find(int id) {
        return users.get(id);
    }

    public boolean login(int userId) {
        if (users.containsKey(userId)) {
            System.out.println("User " + userId + " logged in.");
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public void logout(int userId) {
        System.out.println("User " + userId + " logged out.");
    }
}
